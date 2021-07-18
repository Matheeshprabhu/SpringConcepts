package com.math.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.math.demo.dao.EmployeeRepo;
import com.math.demo.dao.ProjectRepo;
import com.math.demo.entities.Employee;
import com.math.demo.entities.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectRepo repo;
	
	@Autowired
	EmployeeRepo empRepo;
	
	@GetMapping("/register")
	public String register(Model model) {
		
		Project firstProject = new Project();
		List<Employee> empList = empRepo.findAll();
		model.addAttribute("project", firstProject);
		model.addAttribute("allEmployees", empList);
		
		return "project/index.html";
	}
	
	@PostMapping("/save")
	public String saveProject(Project project, Model model, @RequestParam List<Integer> employees) {
		repo.save(project);
//		Iterable<Employee> chosenEmployee= empRepo.findAllById(employees);  // This logic is for ManyToOne, since we're using ManyToMany I'm commenting this
//		
//		for(Employee emp : chosenEmployee) {
//			emp.setProject(project);
//			empRepo.save(emp);
//		}
//		
		return "redirect:/project/register";
	}
	

}
