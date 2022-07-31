package com.maytech.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maytech.hibernate.entity.songs;

public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		//create configuration
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cgg.xml");
    	configuration.addAnnotatedClass(songs.class);
    	
    	//create sessionFactory
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	
    	//Initialize the session object
    	return sessionFactory;
	}
}
