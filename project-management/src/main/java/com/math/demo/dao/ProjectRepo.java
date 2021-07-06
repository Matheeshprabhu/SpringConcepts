package com.math.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.math.demo.entities.Project;

public interface ProjectRepo extends CrudRepository<Project, Integer>  {

	@Override
	public List<Project> findAll();
}
