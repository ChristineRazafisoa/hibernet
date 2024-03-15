/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occuper.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Occuper;
import manager.OccuperManager;
import java.util.List;

/**
 *
 * @author Bota
 */
public class ListeOccuperServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Occuper> occupers = OccuperManager.listeOccoper();
        request.setAttribute("occupers", occupers);
        int totalOccupations = occupers.size();

           request.setAttribute("success", request.getParameter("success"));
       request.setAttribute("error", request.getParameter("error"));       
       request.setAttribute("edit", request.getParameter("edit"));      
       request.setAttribute("delete", request.getParameter("delete"));
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/Occuper/listeOccuper.jsp").forward(request, response);
        
    }
}
