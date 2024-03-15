/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prof.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.ProfManager;
import bean.Prof;
import java.util.*;

/**
 *
 * @author Bota
 */
public class ListeProfServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        List<Prof> profs = ProfManager.listeProf();
        request.setAttribute("profs", profs);

       request.setAttribute("success", request.getParameter("success"));
       request.setAttribute("error", request.getParameter("error"));       
       request.setAttribute("edit", request.getParameter("edit"));      
       request.setAttribute("delete", request.getParameter("delete"));



    
        this.getServletContext().getRequestDispatcher("/WEB-INF/Prof/listeProf.jsp").forward(request, response);

    }
}
