package com.cg.controller;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;

public class EmployeeController {

	public EmployeeService service;
	
	
	public void setService(EmployeeService service) {
		this.service = service;
	}

	public void addEmployee(HashMap<String, String> emp) {
		service.addEmployee(emp);
	}

	public HashMap<Integer, Employee> viewAllEmp() {
		return service.viewAllEmp();
	}

	public Employee getEmployeeById(int id) {
		return service.getEmployeeById(id);
	}

	public void deleteEmployee(int id) {
		service.deleteEmployee(id);
	}
}
