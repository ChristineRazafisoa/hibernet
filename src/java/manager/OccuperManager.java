/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import bean.*;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Bota
 */
public class OccuperManager {
    
    public static void ajouterOccuper (Date d, int idProf, int idSal) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Prof prof = (Prof) session.get(Prof.class, idProf);
        Salle sal = (Salle) session.get(Salle.class, idSal);
        Occuper o = new Occuper(prof, sal, d);
        
        
        session.save(o);
        session.getTransaction().commit();
        
    }
    
    public  static  void modifierOccuper(int id,Date d, int idProf, int idSal){
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Prof prof = (Prof) session.get(Prof.class, idProf);
        Salle sal = (Salle) session.get(Salle.class, idSal);
        
        Occuper o = (Occuper)session.get(Occuper.class , id);
        o.setDate(d);
        o.setProf(prof);
        o.setSalle(sal);
        
        session.update(o);
        session.getTransaction().commit();
      
    }
        public  static  void supprimerOccuper(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Occuper o = (Occuper) session.get(Occuper.class , id);
        
        session.delete(o);
        session.getTransaction().commit();
        
    }
        
     public static List<Occuper> listeOccoper(){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         
         Query query = session.createQuery("FROM Occuper");
         List<Occuper> o = query.list();
         
         session.getTransaction().commit();
         return o;
         
         
         
         
     }
    
    public static Occuper getById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Occuper p = (Occuper) session.get(Occuper.class, id);
        session.getTransaction().commit();
        return p;
    }

    public static void ajouterOccuper(int idProf, int idSal, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
