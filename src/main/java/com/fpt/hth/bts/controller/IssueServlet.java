package com.fpt.hth.bts.controller;

import com.fpt.hth.bts.dao.IssueDAO;
import com.fpt.hth.bts.dao.UserDAO;
import com.fpt.hth.bts.entity.Issue;
import com.fpt.hth.bts.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dinhquangtrung on 4/5/15.
 */
@WebServlet(name = "IssueServlet", urlPatterns = {"/issue"})
public class IssueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

                UserDAO userDAO = new UserDAO();
                User creator = userDAO.read(issue.getCreatorId());


                request.setAttribute("issue", issue);
                request.getRequestDispatcher("WEB-INF/issue/view.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
        }
    }
}
