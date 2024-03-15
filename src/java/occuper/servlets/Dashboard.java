/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occuper.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.*;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Bota
 */
@WebServlet(name = "Dashboard", urlPatterns = {"/dashboard"})
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        List v = session.createSQLQuery("select count(Occuper.id_sal) as total, Prof.nom from Occuper, Prof where Occuper.id_prof=Prof.id group by Prof.nom, Prof.prenom").list();
        
        
        
        ArrayList totalS = new ArrayList();
        ArrayList listeProf = new ArrayList();
        List p = session.createQuery("from Prof").list();  
        List s = session.createQuery("from Salle").list();
        List oc = session.createQuery("from Occuper").list();
        
        session.getTransaction().commit();
        Iterator i = v.iterator();
        
        while(i.hasNext()) {
            Object[] o = (Object[]) i.next();
            totalS.add(o[0]);
            listeProf.add("'" + o[1] +  "'");
        }
        
        request.setAttribute("totalProf", p.size());
        request.setAttribute("totalSalle", s.size());
        request.setAttribute("totalOccuper", oc.size());
        request.setAttribute("totalS", totalS);
        request.setAttribute("listeProf", listeProf);
        request.setAttribute("occupers", oc);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

}
