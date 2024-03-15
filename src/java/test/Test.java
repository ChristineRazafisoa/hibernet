/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import util.HibernateUtil;
import manager.ProfManager;
import manager.*;
import bean.*;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Bota
 */
public class Test {
    
    public static void main(String[] args) {
        
        try{
            //OccuperManager.supprimerOccuper(3);
          //  OccuperManager.modifierOccuper(3, new Date(), 2, 2);
          //  OccuperManager.ajouterOccuper(new Date(), 2, 1);
            //Prof p = new Prof("prof005", "Sharon", "Constancia", "Chef");
           // Salle sal = new Salle("Sal002", "Libre");
           // SalleManager.ajouterSalle(sal);
            //SalleManager.modifierSalle(2, sal);
            //ProfManager.supprimerProf(1);
            List<Salle> s = SalleManager.listeSalles();
            for (Salle sal : s) {
                System.out.println(sal.getDesignation());
            }
            
            
           // Salle salle = new Salle("Salle001", "Occuper");
            //SalleManager sm = new SalleManager();
         //   SalleManager.ajouterSalle(salle);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
        
    }
    
}
