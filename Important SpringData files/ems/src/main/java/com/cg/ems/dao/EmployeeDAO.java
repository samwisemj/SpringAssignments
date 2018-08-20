package com.cg.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ems.bean.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
	
//	@Query("Select * from emp")
	public List<Employee> findByEmpName(String empName);
	
	public List<Employee> findByEmpIdOrEmpName(int id, String name);
	
	@Query(
			  value = "SELECT * from employee WHERE designation IS null",
			  nativeQuery = true)
	public List<Employee> myQuery();
	
	//public List<Employee> findDistinctByNameNotIn(List<String> names);
	
}