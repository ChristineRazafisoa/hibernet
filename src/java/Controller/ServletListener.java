/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import util.HibernateUtil;

/**
 * Web application lifecycle listener.
 *
 * @author Bota
 */
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        HibernateUtil.getSessionFactory().close();
        
    }
}
