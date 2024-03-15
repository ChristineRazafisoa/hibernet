/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salle.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.SalleManager;
import bean.Salle;
import java.util.List;

/**
 *
 * @author Bota
 */
public class ListeSalle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Salle> salles = SalleManager.listeSalles();
        request.setAttribute("salles", salles);
        
           request.setAttribute("success", request.getParameter("success"));
       request.setAttribute("error", request.getParameter("error"));       
       request.setAttribute("edit", request.getParameter("edit"));      
       request.setAttribute("delete", request.getParameter("delete"));
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/Salle/listeSalle.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    

}
