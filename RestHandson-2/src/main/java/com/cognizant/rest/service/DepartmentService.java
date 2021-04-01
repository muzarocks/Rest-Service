package com.cognizant.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.dao.DepartmentDao;
import com.cognizant.rest.model.Department;



@Service
public class DepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public List<Department> getAllDepartments() {
		LOGGER.info("Start");
		
		List<Department> departments = departmentDao.getAllDepartments();
		
		LOGGER.info("End");
		return departments;
	}
	
	
	
}
