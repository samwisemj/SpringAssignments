package com.cg.service;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDAO;

public class EmployeeService {

	public EmployeeDAO dao;


	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	public void addEmployee(Map<String, String> emp) {
		dao.addEmployee(emp);
	}

	public HashMap<Integer, Employee> viewAllEmp() {
		return dao.viewAllEmp();
	}

	public Employee getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}

	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}
}
