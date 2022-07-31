package com.maytech.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.mysql.cj.jdbc.Driver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    	//create configuration
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cgg.xml");
    	configuration.addAnnotatedClass(songs.class);
    	
    	//create sessionFactory
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	
    	//Initialize the session object
    	Session session = sessionFactory.openSession();
    	
        
    	songs song1 = new songs();
    	song1.setId(1);
    	song1.setSongName("hey Dil");
    	song1.setArtist("himesh");
    	
    	session.beginTransaction();
    	session.save(song1);
    	session.getTransaction().commit();
    	
    	System.out.println("song saved");
    }
}
