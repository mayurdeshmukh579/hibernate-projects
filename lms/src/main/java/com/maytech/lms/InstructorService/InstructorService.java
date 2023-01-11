package com.maytech.lms.InstructorService;

import java.util.List;

import com.maytech.lms.entitty.Instructor;

public interface InstructorService {
	
	List<Instructor> findAllInstructors();

	public void saveInstructor(Instructor instructor);

	public Instructor searchInstructor(int id);

	public void deleteInstructorId(int id);
}
