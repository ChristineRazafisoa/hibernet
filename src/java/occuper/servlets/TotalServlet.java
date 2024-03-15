/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occuper.servlets;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Prof;
import bean.Salle;
import manager.ProfManager;
import manager.SalleManager;

public class TotalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupération des données
        List<Prof> profs = ProfManager.listeProf();
        List<Salle> salles = SalleManager.listeSalles();

        // Compter le nombre de salles par professeur
        Map<Prof, Integer> profsToSalleCount = new HashMap<>();
        for (Prof prof : profs) {
            int salleCount = 0;
            for (Salle salle : salles) {
                // TODO : Accéder aux occupations et vérifier si le professeur occupe la salle
                if (salle.isOccupeePar(prof)) {
                    salleCount++;
                }
            }
            profsToSalleCount.put(prof, salleCount);
        }

        // Envoi des données à la page JSP
        request.setAttribute("profsToSalleCount", profsToSalleCount);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
