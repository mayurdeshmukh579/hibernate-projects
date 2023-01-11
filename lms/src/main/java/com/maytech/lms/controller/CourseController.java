package com.maytech.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.maytech.lms.CourseService.CourseService;
import com.maytech.lms.dto.LessonCountDto;
import com.maytech.lms.entitty.Course;
import com.maytech.lms.entitty.Lesson;

@SessionAttributes("lessonCount")
@Controller
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/viewCourse")
	public String showCoursePage(@RequestParam("courseId") int courseId, Model model) {

		Course course = courseService.findCourseId(courseId);
		model.addAttribute("course", course);
		int fistLessonNumber = course.getLessons().get(0).getId();
		
		int lastLessonNumber = (fistLessonNumber+course.getLessons().size())-1;
		
		LessonCountDto lessonCountDto = new LessonCountDto();
		lessonCountDto.setFistLessonNumber(fistLessonNumber);
		lessonCountDto.setLastLessonNumber(lastLessonNumber);
		
		model.addAttribute("lessonCountDto",lessonCountDto);

		return "course-page";

	}

	@GetMapping("/openLesson")

	public String openLesson(@RequestParam("id") int id, Model model) {

		Lesson lesson = courseService.findLessonById(id);
		model.addAttribute("lesson", lesson);
		return "lesson-page";

	}
}
