package com.maytech.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maytech.lms.dao.InstructorDAO;
import com.maytech.lms.entitty.Instructor;

@Controller
public class InstructorController {
	
	@Autowired
	private InstructorDAO instructorDAO;
	
	@RequestMapping("/instructor-info")
	public String showInstructorHomePage(Model model) {
		
		List<Instructor>  instructorList= instructorDAO.findAllInstructors();
		model.addAttribute("instructorList",instructorList );
		return "instructor-home";
	}
}
