package com.cognizant.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.dao.EmployeeDao;
import com.cognizant.rest.model.Employee;
import com.cognizant.rest.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {
		LOGGER.info("Start");

		List<Employee> employees = employeeDao.getAllEmployees();
		
		LOGGER.info("End");
		
		return employees;
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Start");

		employeeDao.updateEmployee(employee);

		LOGGER.info("End");
	}
	
	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
		employeeDao.deleteEmployee(employee);
	}
}