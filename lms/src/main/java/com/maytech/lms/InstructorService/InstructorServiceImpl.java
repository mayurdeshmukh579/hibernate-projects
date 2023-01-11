package com.maytech.lms.InstructorService;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Service;

import com.maytech.lms.dao.InstructorDAO;
import com.maytech.lms.entitty.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO instructorDAO;

	@Transactional
	@Override
	public List<Instructor> findAllInstructors() {

		List<Instructor> findAllInstructors = instructorDAO.findAllInstructors();

		for (Instructor instructor : findAllInstructors) {
			instructor.setName(instructor.getName().toUpperCase());
			// one way to resolve lazy error
			Hibernate.initialize(instructor.getCourses());
		}

		return findAllInstructors;
	}

	@Transactional
	@Override
	public void saveInstructor(Instructor instructor) {

		instructorDAO.saveInstructor(instructor);
	}

	@Transactional
	@Override
	public Instructor searchInstructor(int id) {

		Instructor searchInstructorById = instructorDAO.searchInstructorById(id);

		return searchInstructorById;
	}

	@Transactional
	@Override
	public void deleteInstructorId(int id) {

		instructorDAO.deleteInstructorById(id);

	}

}
