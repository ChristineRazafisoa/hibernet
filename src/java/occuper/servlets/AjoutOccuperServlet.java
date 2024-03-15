/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occuper.servlets;

import bean.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;  
import manager.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bota
 */
public class AjoutOccuperServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       List<Prof> profs = ProfManager.listeProf();
        List<Salle> salles = SalleManager.listeSalles();
        
       request.setAttribute("profs", profs);
        request.setAttribute("salles", salles);
                
        this.getServletContext().getRequestDispatcher("/WEB-INF/Occuper/ajouterOccuper.jsp").forward(request, response);

    }

   
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    try {
        int idSal = Integer.parseInt(request.getParameter("idsal"));
        int idProf = Integer.parseInt(request.getParameter("idprof"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        
        OccuperManager.ajouterOccuper(date, idProf, idSal);
        
        // Rediriger après l'ajout réussi
        response.sendRedirect("http://localhost:8080/GestionSalle/occuper?success=true");
    } catch (NumberFormatException | ParseException ex) {
        // Gérer les erreurs de conversion ou de parsing
                response.sendRedirect("http://localhost:8080/GestionSalle/occuper?error=true");

        Logger.getLogger(AjoutOccuperServlet.class.getName()).log(Level.SEVERE, "Erreur lors de l'ajout de l'occupation", ex);
        
        // Envoyer un message d'erreur à l'utilisateur
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Erreur lors de l'ajout de l'occupation</h3>");
        out.println("<p>Veuillez vérifier vos entrées et réessayer.</p>");
    }
}


}
