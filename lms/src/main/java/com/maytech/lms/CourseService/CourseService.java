package com.maytech.lms.CourseService;

import com.maytech.lms.entitty.Course;
import com.maytech.lms.entitty.Lesson;

public interface CourseService {

	public Course findCourseId(int id);
	
	public Lesson findLessonById(int id);
	
}
