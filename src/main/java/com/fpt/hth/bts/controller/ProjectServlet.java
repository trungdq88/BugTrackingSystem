package com.fpt.hth.bts.controller;

import com.fpt.hth.bts.dao.IssueDAO;
import com.fpt.hth.bts.dao.LabelDAO;
import com.fpt.hth.bts.dao.ProjectDAO;
import com.fpt.hth.bts.entity.Project;

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
@WebServlet(name = "ProjectServlet", urlPatterns = {"/project"})
public class ProjectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("/");
            return;
        }
        if (action.equals("create")) {
            String name = request.getParameter("project-name");
            String code = request.getParameter("project-code");
            String date = request.getParameter("project-date");
            String description = request.getParameter("project-description");

            Project project = new Project();
            project.setName(name);
            project.setCode(code);
            project.setStartDate(new Date());
            project.setDescription(description);

            ProjectDAO dao = new ProjectDAO();
            if (code == null || code.isEmpty() || dao.isCodeExists(code)) {
                request.setAttribute("message", "Error: project code is empty or duplicated!");
            } else {
                Project result = dao.create(project);
                if (result != null) {
                    request.setAttribute("message", "Project created!");
                } else {
                    request.setAttribute("message", "There is problem when create new project!");
                }
            }
            request.getRequestDispatcher("WEB-INF/common/message.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect("/");
            return;
        }

        ProjectDAO projectDAO = null;
        int projectId = 0;
        Project project = null;
        if (action.equals("view")
                || action.equals("label")
                || action.equals("milestone")
                || action.equals("member")) {
            projectDAO = new ProjectDAO();
            projectId = Integer.parseInt(request.getParameter("id"));
            project = projectDAO.read(projectId);
            request.setAttribute("project", project);
        }
        if (action.equals("create")) {
            request.getRequestDispatcher("WEB-INF/project/create.jsp").forward(request, response);
        } else if (action.equals("view")) {

            String status = request.getParameter("status");
            if (status == null || status.isEmpty()) {
                status = "open";
            }

            IssueDAO issueDAO = new IssueDAO();

            List issues = issueDAO.getAllByProject(projectId, status.equals("open"));

            assert projectDAO != null;
            int openCount = projectDAO.getIssueCount(projectId, true);
            int closeCount = projectDAO.getIssueCount(projectId, false);

            request.setAttribute("issues", issues);
            request.setAttribute("openCount", openCount);
            request.setAttribute("closeCount", closeCount);

            request.getRequestDispatcher("WEB-INF/project/detail-issue.jsp").forward(request, response);
        } else if (action.equals("label")) {
            LabelDAO labelDAO = new LabelDAO();

            List labels = labelDAO.getAllByProject(projectId);
            request.setAttribute("labels", labels);

            request.getRequestDispatcher("WEB-INF/project/detail-label.jsp").forward(request, response);
        } else if (action.equals("milestone")) {
            request.getRequestDispatcher("WEB-INF/project/detail-milestone.jsp").forward(request, response);
        } else if (action.equals("member")) {
            request.getRequestDispatcher("WEB-INF/project/detail-member.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
        }
    }
}
