/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;
import org.hibernate.*;
import bean.Salle;
import util.HibernateUtil;
import java.util.*;

/**
 *
 * @author Bota
 */
public class SalleManager {
    
    public static void ajouterSalle(Salle salle){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        session.save(salle);
        session.getTransaction().commit();
    }
    
    public  static  void modifierSalle(int id , Salle salle){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Salle sal = (Salle)session.get(Salle.class , id);
        sal.setCodesal(salle.getCodesal());
        sal.setDesignation(salle.getDesignation());
        
        session.update(sal);
        session.getTransaction().commit();
      
    }
    
    public  static  void supprimerSalle(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Salle sal = (Salle)session.get(Salle.class , id);
        session.delete(sal);
        session.getTransaction().commit();
         
    }
    
    public  static  List<Salle> listeSalles(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createQuery("FROM Salle");
        List<Salle> salle = query.list();
        
       
        session.getTransaction().commit();
        
        return salle;
        
    }
    
    
    public static Salle getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Salle salle = (Salle) session.get(Salle.class, id);
        
        session.getTransaction().commit();
        return salle;
    }
}
