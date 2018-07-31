package com.frc.consumer.util;


import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
    public static SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    

    
    public 	static SessionFactory buildSessionFactory(){
    	
    	try {
    		
    		Configuration configuration = new Configuration();
    		
    		configuration.configure("config/hibernate.cfg.xml");
    		
    		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    		
    		return configuration.buildSessionFactory(serviceRegistry);
    		
    		
    		
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    		
    }


        
   // public static final ThreadLocal session = new ThreadLocal();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    public static Session openSession() {
   
    	return sessionFactory.openSession();
    	
    	
    }
    
    public Session getCurrentSession() {
    	
    	return sessionFactory.getCurrentSession();
    }
    
    public static void close(){
    	
    	if(sessionFactory!=null) {
    		
    		sessionFactory.close();
    	}
    	
    	sessionFactory=null;
    }
    
    
}