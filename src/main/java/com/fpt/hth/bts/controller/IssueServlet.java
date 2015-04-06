package com.fpt.hth.bts.controller;

import com.fpt.hth.bts.dao.*;
import com.fpt.hth.bts.entity.*;
import com.fpt.hth.bts.utils.BTSConstants;
import com.fpt.hth.bts.utils.DummyVal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by dinhquangtrung on 4/5/15.
 */
@WebServlet(name = "IssueServlet", urlPatterns = {"/issue"})
public class IssueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("/");
            return;
        }
        if (action.equals("comment")) {
            String commentStr = request.getParameter("issue-comment");
            int issueId = Integer.parseInt(request.getParameter("issue-id"));

            if (commentStr == null || commentStr.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/issue?action=view&id=" + issueId);
                return;
            }

            Comment comment = new Comment();
            comment.setCommentContent(commentStr);
            comment.setCreatedDate(new Date());
            comment.setIssueId(issueId);

            UserDAO userDAO = new UserDAO();
            User loggedUser = userDAO.read(DummyVal.loggedInUserId);
            comment.setUserId(loggedUser.getId());
            comment.setUsername(loggedUser.getUsername());

            CommentDAO commentDAO = new CommentDAO();
            commentDAO.create(comment);
            response.sendRedirect(request.getContextPath() + "/issue?action=view&id=" + issueId);
        } else if (action.equals("create")) {
            String name = request.getParameter("issue-name");
            String description = request.getParameter("issue-description");
            int projectId = Integer.parseInt(request.getParameter("project-id"));

            if (description == null || description.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/issue?action=create");
                return;
            }

            UserDAO userDAO = new UserDAO();
            User user = userDAO.read(DummyVal.loggedInUserId);

            Issue issue = new Issue();
            issue.setStatus(BTSConstants.ISSUE_OPEN_STATUS);
            issue.setContent(description);
            issue.setName(name);
            issue.setCreateDate(new Date());
            issue.setProjectId(projectId);
            issue.setCreatorId(user.getId());
            issue.setUsername(user.getUsername());

            // DAOs
            IssueDAO issueDAO = new IssueDAO();
            issue = issueDAO.create(issue);
            response.sendRedirect(request.getContextPath() + "/issue?action=view&id=" + issue.getId());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("/");
            return;
        }
        if (action.equals("create")) {
            request.getRequestDispatcher("WEB-INF/issue/create.jsp").forward(request, response);
        } else if (action.equals("view")) {
            String idStr = request.getParameter("id");
            int issueId = 0;
            if (idStr != null) {
                try {
                    issueId = Integer.parseInt(idStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            IssueDAO issueDAO = new IssueDAO();
            Issue issue;
            if (issueId != 0 && (issue = issueDAO.read(issueId)) != null) {

                // DAOs
                CommentDAO commentDAO = new CommentDAO();
                UserDAO userDAO = new UserDAO();
                AssignmentDAO assignmentDAO = new AssignmentDAO();
                MilestoneDAO milestoneDAO = new MilestoneDAO();
                LabelDAO labelDAO = new LabelDAO();
                LabelIssueDAO labelIssueDAO = new LabelIssueDAO();

                // Get user
                User creator = userDAO.read(issue.getCreatorId());

                // Get comments
                List comments = commentDAO.getAllByIssue(issueId);

                // Get labels
                List labels = labelIssueDAO.getAllByIssueId(issueId);

                // Get milestone
                Milestone milestone = null;
                if (issue.getMilestoneId() != null && issue.getMilestoneId() > 0) {
                    milestone = milestoneDAO.read(issue.getMilestoneId());
                }


                // Get assignee
                Assignment assignment = assignmentDAO.getLatestAssignment(issueId);
                User assignee = null;
                if (assignment != null) {
                    assignee = userDAO.read(assignment.getAssigneeId());
                }


                request.setAttribute("issue", issue);
                request.setAttribute("creator", creator);
                request.setAttribute("comments", comments);
                request.setAttribute("assignee", assignee);
                request.setAttribute("milestone", milestone);
                request.setAttribute("labels", labels);

                request.getRequestDispatcher("WEB-INF/issue/view.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
            }
        } else if (action.equals("close") || action.equals("reopen")) {

            String idStr = request.getParameter("id");
            int issueId = 0;
            if (idStr != null) {
                try {
                    issueId = Integer.parseInt(idStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            IssueDAO issueDAO = new IssueDAO();
            Issue issue;
            if (issueId != 0 && (issue = issueDAO.read(issueId)) != null) {
                issue.setStatus(
                        action.equals("reopen") ?
                                BTSConstants.ISSUE_OPEN_STATUS :
                                BTSConstants.ISSUE_CLOSE_STATUS);
                issueDAO.update(issue);
            }

            response.sendRedirect(request.getContextPath() + "/issue?action=view&id=" + issueId);
        } else {
            request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
        }
    }
}
