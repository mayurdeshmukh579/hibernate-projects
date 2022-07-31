package com.maytech.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.maytech.hibernate.entity.songs;
import com.maytech.hibernate.utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class CreateApp 
{
    public static void main( String[] args )
    {
    	
    	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    	
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
