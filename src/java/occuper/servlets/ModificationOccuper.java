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
import bean.*;
import manager.*;
import java.util.*;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bota
 */
public class ModificationOccuper extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != "" && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Occuper o = OccuperManager.getById(id);
            
            int idSal = o.getSalle().getId();
            int idProf = o.getProf().getId();
            Date date = o.getDate(); 
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = formatter.format(date);  
            
            System.out.println(strDate);
        
            List<Prof> profs = ProfManager.listeProf();
            List<Salle> salles = SalleManager.listeSalles();

            request.setAttribute("profs", profs);
            request.setAttribute("salles", salles);
            
            request.setAttribute("idSal", idSal);
            request.setAttribute("idProf", idProf);
            request.setAttribute("date", strDate); 
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/Occuper/modifierOccuper.jsp").forward(request, response);
        } else {
            response.sendRedirect("http://localhost:8080/GestionSalle/occuper");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idSal = Integer.parseInt(request.getParameter("idsal"));
        int idProf = Integer.parseInt(request.getParameter("idprof"));
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            OccuperManager.modifierOccuper(id, date, idProf, idSal);
            response.sendRedirect("http://localhost:8080/GestionSalle/occuper?edit=true");
        } catch (ParseException ex) {
            Logger.getLogger(AjoutOccuperServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
