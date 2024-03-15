/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof.servlets;

import bean.Prof;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.ProfManager;

/**
 *
 * @author Bota
 */
public class AjoutProfServlet extends HttpServlet {



   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
               this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/ajouterProf.jsp").forward(request, response);


   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      Prof p = new Prof(request.getParameter("codeprof"), request.getParameter("nom")
              , request.getParameter("prenom"), request.getParameter("grade"));
        try{
            ProfManager.ajouterProf(p);
            response.sendRedirect("http://localhost:8080/GestionSalle/prof?success=true");
        } catch (Exception e) {
            response.sendRedirect("http://localhost:8080/GestionSalle/prof?error=true");
        }


   }

   
   @Override
   public String getServletInfo() {
       return "Short description";
   }// </editor-fold>

}