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

/**
 *
 * @author Bota
 */
public class AjoutSalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Salle/ajoutSalle.jsp").forward(request, response);
    }

    @Override
 //   @RequestMapping(value="create" , method=RequestMethod.Pst)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Salle s = new Salle(request.getParameter("codesal"), request.getParameter("designation"));
       
        
        try{
           SalleManager.ajouterSalle(s);
              response.sendRedirect("http://localhost:8080/GestionSalle/salle?success=true");
        } catch (Exception e) {
            response.sendRedirect("http://localhost:8080/GestionSalle/salle?error=true");
        } 
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
