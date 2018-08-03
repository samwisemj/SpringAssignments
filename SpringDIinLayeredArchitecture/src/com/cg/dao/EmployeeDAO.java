package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bean.*;

public class EmployeeDAO {

	HashMap<Integer, Employee> employees = new HashMap<>();

	public void addEmployee(Map<String, String> emp) {
		Employee e = new Employee(Integer.parseInt(emp.get("id")), emp.get("name"));
		employees.put(Integer.parseInt(emp.get("id")), e);
	}

	public HashMap<Integer, Employee> viewAllEmp() {
		return employees;
	}

	public Employee getEmployeeById(int id) {
		return employees.get(id);
	}

	public void deleteEmployee(int id) {
		employees.remove(id);
	}
	

}
