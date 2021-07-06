package com.math.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.math.demo.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	@Override
	public List<Employee> findAll();
}
