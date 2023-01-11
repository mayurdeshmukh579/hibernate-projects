package com.maytech.lms.CourseService;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.maytech.lms.dao.CourseDao;
import com.maytech.lms.entitty.Course;
import com.maytech.lms.entitty.Lesson;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
	@Transactional
	@Override
	public Course findCourseId(int id) {

		Course findCourseId = courseDao.findCourseId(id);
		
		//to solve lazy error
		Hibernate.initialize(findCourseId.getLessons());
		
		return findCourseId;
	}

	@Transactional
	@Override
	public Lesson findLessonById(int id) {

		Lesson lesson = courseDao.findLessonById(id);
		return lesson;
	}

}
