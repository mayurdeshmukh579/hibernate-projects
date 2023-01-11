package com.maytech.lms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maytech.lms.InstructorService.InstructorService;
import com.maytech.lms.dto.SearchDTO;
import com.maytech.lms.entitty.Instructor;

@Controller
public class InstructorController {

	@Autowired
	private InstructorService instructorService;

	@GetMapping("/instructor-info")
	public String showInstructorHomePage(Model model) {

		List<Instructor> instructorList = instructorService.findAllInstructors();
		model.addAttribute("instructorList", instructorList);
		model.addAttribute("SearchDTO", new SearchDTO());

		return "instructor-home";
	}

	@RequestMapping("/add-instructor")
	public String showInsertInstructor(Model model) {

		model.addAttribute("instructor", new Instructor());

		return "add-Instructor";

	}

	@RequestMapping("/submit-instructor")
	public String addInsertInstructor(Instructor instructor) {

		instructorService.saveInstructor(instructor);

		return "redirect:/instructor-info";

	}

	@GetMapping("/process-search")
	public String searchById(@RequestParam("id") int id, Model model) {

		ArrayList<Instructor> instructors = new ArrayList<Instructor>();

		Instructor searchInstructor = instructorService.searchInstructor(id);
		instructors.add(searchInstructor);

		model.addAttribute("instructorList", instructors);
		model.addAttribute("SearchDTO", new SearchDTO());

		return "instructor-home";
	}

	@RequestMapping("/deleteInstructor")
	public String deleteAInstructor(@RequestParam("id") int id) {

		instructorService.deleteInstructorId(id);

		return "redirect:/instructor-info";
	}
}
