/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salle.servlets;

import bean.Salle;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.SalleManager;

/**
 *
 * @author Bota
 */
@WebServlet(name = "SupprimerSalle", urlPatterns = {"/salle/supprimer"})
public class SupprimerSalle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != "" && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            SalleManager.supprimerSalle(id);
        }
        response.sendRedirect("http://localhost:8080/GestionSalle/salle?delete=true");
    }
}
