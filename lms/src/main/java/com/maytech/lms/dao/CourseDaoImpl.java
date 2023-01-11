package com.maytech.lms.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maytech.lms.entitty.Course;
import com.maytech.lms.entitty.Lesson;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Course findCourseId(int id) {

		Session session = sessionFactory.getCurrentSession();
		Course course = session.get(Course.class, id);

		return course;
	}

	@Override
	public Lesson findLessonById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Lesson lesson = session.get(Lesson.class, id);
		
		return lesson;
	}

}
