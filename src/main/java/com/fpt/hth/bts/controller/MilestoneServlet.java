/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpt.hth.bts.controller;

import com.fpt.hth.bts.dao.LabelDAO;
import com.fpt.hth.bts.dao.MilestoneDAO;
import com.fpt.hth.bts.entity.Label;
import com.fpt.hth.bts.entity.Milestone;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class MilestoneServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action = request.getParameter("action");

        if (action.equals("create")) {
            String description = request.getParameter("description");
            String name = request.getParameter("name");
//            String date = request.getParameter("date") == null ? "" : request.getParameter("date");
            Calendar calendar = new GregorianCalendar(2015, 5, 12);
            Date deadline = calendar.getTime();
            String projectId = request.getParameter("projectId") == null ? "0" : request.getParameter("projectId");
            int project = Integer.parseInt(projectId);
            Milestone  milestone = new Milestone();
            milestone.setDeadline(deadline);
            milestone.setName(name);
            milestone.setDescription(description);
            milestone.setProjectId(project);

            MilestoneDAO dao = new MilestoneDAO();
            if (name == null || name.isEmpty() || project == 0) {
                request.setAttribute("message", "Error: project code is empty or duplicated!");
            } else {
                Milestone result = dao.create(milestone);
                if (result != null) {
                    request.setAttribute("message", "Project created!");
                } else {
                    request.setAttribute("message", "There is problem when create new project!");
                }
            }
            request.getRequestDispatcher("WEB-INF/common/message.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/error/404.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
