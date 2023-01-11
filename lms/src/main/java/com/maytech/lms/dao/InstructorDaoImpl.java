package com.maytech.lms.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.maytech.lms.entitty.Instructor;


@Repository
public class InstructorDaoImpl implements InstructorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Instructor> findAllInstructors() {

		//open session
		
		Session session = sessionFactory.getCurrentSession();
		
		
		//do some query to fectch all instructor
		
		Query<Instructor> qury = session.createQuery("from Instructor",Instructor.class);
		List<Instructor> list = qury.list();		
		
		return list;
	}


	@Override
	@Transactional
	public void saveInstructor(Instructor instructor) {

		Session session = sessionFactory.getCurrentSession();
		
		
		
		Serializable save = session.save(instructor);
		
	}


	@Override
	public Instructor searchInstructorById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Instructor instructor = session.get(Instructor.class, id);
		
		return instructor;
	}


	@Override
	public void deleteInstructorById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Instructor instructor = session.get(Instructor.class, id);
		session.delete(instructor);
	}

}
