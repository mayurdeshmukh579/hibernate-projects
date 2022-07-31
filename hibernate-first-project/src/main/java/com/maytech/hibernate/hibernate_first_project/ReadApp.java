package com.maytech.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.maytech.hibernate.entity.songs;
import com.maytech.hibernate.utils.HibernateUtils;

public class ReadApp {
	public static void main( String[] args )
    {
    	
    	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	session.beginTransaction();
    	songs songs = session.get(songs.class, 1);
    	session.getTransaction().commit();
    	
    	System.out.println(songs);
    	System.out.println("song Read");
    }
}
