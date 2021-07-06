package com.math.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.math.demo.dao.EmployeeRepo;
import com.math.demo.dao.ProjectRepo;
import com.math.demo.entities.Employee;
import com.math.demo.entities.Project;

@Controller
@RequestMapping("/display")
public class DisplayController {
	
	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	ProjectRepo projRepo;
	
	@GetMapping("/display-table")
	public String displayTable(Model model) {
		
	List<Employee> employee = empRepo.findAll();
	List<Project> project = projRepo.findAll();
	model.addAttribute("projectList", project);
	model.addAttribute("employeeList", employee);
	
	return "main/table-display" ;
	}
	
	

}
