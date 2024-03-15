/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import org.hibernate.Session;
import bean.Prof;
import java.util.List;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Bota
 */
public class ProfManager {
    
    public static void ajouterProf (Prof p) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        session.save(p);
        session.getTransaction().commit();
        
    }
    
    public  static  void modifierProf(int id , Prof nouveauProf){
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Prof professeur = (Prof)session.get(Prof.class , id);
        
        professeur.setCodeprof(nouveauProf.getCodeprof());
        professeur.setNom(nouveauProf.getNom());
        professeur.setPrenom(nouveauProf.getPrenom());
        professeur.setGrade(nouveauProf.getGrade());
      
        session.update(professeur);
        session.getTransaction().commit();
       
    }
    
    public static void supprimerProf(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Prof professeur = (Prof)session.get(Prof.class , id);
        
        session.delete(professeur);
        session.getTransaction().commit();
       
    }
    
    public  static  List<Prof> listeProf(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createQuery("FROM Prof");
        List<Prof> prof = query.list();
        
        session.getTransaction().commit();
        return prof;
    
    }
    
    public static Prof getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Prof p = (Prof) session.get(Prof.class, id);
        session.getTransaction().commit();
        return p;
    }
    
}
