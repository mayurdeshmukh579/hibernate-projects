package com.maytech.lms.dao;

import java.util.List;


import com.maytech.lms.entitty.Instructor;

public interface InstructorDAO {

	List<Instructor> findAllInstructors();

	public void saveInstructor(Instructor instructor);

	public Instructor searchInstructorById(int id);

	public void deleteInstructorById(int id);
}
