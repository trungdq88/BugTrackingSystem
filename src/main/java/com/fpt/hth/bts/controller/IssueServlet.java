package com.fpt.hth.bts.controller;

import com.fpt.hth.bts.dao.CommentDAO;
import com.fpt.hth.bts.dao.IssueDAO;
import com.fpt.hth.bts.dao.UserDAO;
import com.fpt.hth.bts.entity.Comment;
import com.fpt.hth.bts.entity.Issue;
import com.fpt.hth.bts.entity.User;
import com.fpt.hth.bts.utils.DummyVal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
                response.sendRedirect("/BTS/issue?action=view&id=" + issueId);
                return;
            }

            Comment comment = new Comment();
            comment.setCommentContent(commentStr);
            comment.setCreatedDate(new Date());
            comment.setIssueId(issueId);
            comment.setUserId(DummyVal.loggedInUserId);

            CommentDAO commentDAO = new CommentDAO();
            commentDAO.create(comment);
            response.sendRedirect("/BTS/issue?action=view&id=" + issueId);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("/");
            return;
        }
        if (action.equals("view")) {
            String idStr = request.getParameter("id");
            int id = 0;
            if (idStr != null) {
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            IssueDAO issueDAO = new IssueDAO();
            Issue issue;
            if (id != 0 && (issue = issueDAO.read(id)) != null) {

                // Get user
                UserDAO userDAO = new UserDAO();
                User creator = userDAO.read(issue.getCreatorId());

                // Get comments
                CommentDAO commentDAO = new CommentDAO();
                List comments = commentDAO.getAllByIssue(issue.getId());

                request.setAttribute("issue", issue);
                request.setAttribute("creator", creator);
                request.setAttribute("comments", comments);

                request.getRequestDispatcher("WEB-INF/issue/view.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
        }
    }
}
