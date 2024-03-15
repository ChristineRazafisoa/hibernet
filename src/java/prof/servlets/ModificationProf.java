/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Prof;
import manager.ProfManager;

/**
 *
 * @author Bota
 */
@WebServlet(name = "ModificationProf", urlPatterns = {"/prof/modifier"})
public class ModificationProf extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != "" && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Prof p = ProfManager.getById(id);
            request.setAttribute("prof", p);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/modifierProf.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/GestionSalle/prof");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Prof p = new Prof();
        p.setCodeprof(request.getParameter("codeprof"));
        p.setGrade(request.getParameter("grade"));
        p.setNom(request.getParameter("nom"));
        p.setPrenom(request.getParameter("prenom"));
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            ProfManager.modifierProf(id, p);
            response.sendRedirect("http://localhost:8080/GestionSalle/prof?edit=true");
        } catch (Exception e) {
            request.setAttribute("salle", p);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/modifierProf.jsp").forward(request, response);
        }
    }
    
}
