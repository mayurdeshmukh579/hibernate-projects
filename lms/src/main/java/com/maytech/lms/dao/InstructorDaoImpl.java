package com.maytech.lms.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.maytech.lms.entitty.Instructor;


@Repository
public class InstructorDaoImpl implements InstructorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Instructor> findAllInstructors() {

		//open session
		
		Session session = sessionFactory.openSession();
		
		///begin transaction 
		
		Transaction beginTransaction = session.beginTransaction();
		
		//do some query to fectch all instructor
		
		Query<Instructor> qury = session.createQuery("from Instructor",Instructor.class);
		List<Instructor> list = qury.list();
		
		//commit transaction
		
		session.getTransaction().commit();
		
		//resturn the list of instructorr
		
		
		return list;
	}

}
