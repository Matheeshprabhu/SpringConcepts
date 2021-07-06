package com.math.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.math.demo.dao.EmployeeRepo;
import com.math.demo.entities.Employee;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmployeeRepo repo;
	
	@GetMapping("/empform")
	public String empForm(Model model){
		
		Employee empObj = new Employee();
		model.addAttribute("emp", empObj);
		
		return "employees/emp-form";
	}
	
	@PostMapping("/save")
	public String saveForm(Employee emp, Model model) {
		repo.save(emp);
		
		return "redirect:/emp/empform";
	}	

}
