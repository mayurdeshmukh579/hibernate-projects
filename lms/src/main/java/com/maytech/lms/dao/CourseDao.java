package com.maytech.lms.dao;

import com.maytech.lms.entitty.Course;
import com.maytech.lms.entitty.Lesson;

public interface CourseDao {

	public Course findCourseId(int id);
	
	public Lesson findLessonById(int id);
}
