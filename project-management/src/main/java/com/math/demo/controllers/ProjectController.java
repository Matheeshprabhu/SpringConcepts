package com.math.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.math.demo.dao.ProjectRepo;
import com.math.demo.entities.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectRepo repo;
	
	@GetMapping("/register")
	public String register(Model model) {
		
		Project firstProject = new Project();
		model.addAttribute("project", firstProject);
		
		return "project/index.html";
	}
	
	@PostMapping("/save")
	public String saveProject(Project project, Model model) {
		repo.save(project);
		return "redirect:/project/register";
	}
	

}
