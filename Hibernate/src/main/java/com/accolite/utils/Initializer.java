package com.accolite.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Initializer {
   
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;
     
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	
        	 serviceRegistry = new StandardServiceRegistryBuilder()
                     .configure("hibernate.cfg.xml")
                     .build();

             sessionFactory = new Configuration().buildSessionFactory( serviceRegistry );
         }
         return sessionFactory;
    }
}
