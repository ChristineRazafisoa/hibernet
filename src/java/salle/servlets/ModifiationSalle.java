/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salle.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.SalleManager;
import bean.Salle;

/**
 *
 * @author Bota
 */
@WebServlet(name = "ModifiationSalle", urlPatterns = {"/salle/modifier"})
public class ModifiationSalle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != "" && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Salle salle = SalleManager.getById(id);
            request.setAttribute("salle", salle);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Salle/modifierSalle.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/GestionSalle/salle");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Salle s = new Salle();
        s.setCodesal(request.getParameter("codesal"));
        s.setDesignation(request.getParameter("designation"));
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            SalleManager.modifierSalle(id, s);
            response.sendRedirect("http://localhost:8080/GestionSalle/salle?edit=true");
        } catch (Exception e) {
            request.setAttribute("salle", s);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Salle/modifierSalle.jsp").forward(request, response);
        }
    }

}
