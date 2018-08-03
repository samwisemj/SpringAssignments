package com.cg.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

import com.cg.bean.Employee;
import com.cg.controller.EmployeeController;



public class UIEmployee {

	Map<String, String> emp;
	EmployeeController ctrl;
	

	public void setCtrl(EmployeeController ctrl) {
		this.ctrl = ctrl;
	}

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void start() throws NumberFormatException, IOException {
		emp = new HashMap<>();
		ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
		EmployeeController ctrl=(EmployeeController) context.getBean("controller");
		setCtrl(ctrl);
		
		accept();
	}

	private void accept() throws NumberFormatException, IOException {
		int ch;
		do
		{
			System.out.println("Enter choice\n1.Add New Employee\n2.View all employees\n3.Get employee by id\n4.Delete an employee\nAny other to exit");
			ch=Integer.parseInt(br.readLine());
			switch(ch)
			{
				case 1:System.out.println("Enter the emp name");
					emp.put("id", String.valueOf(Employee.fetchNextID()));
					emp.put("name", br.readLine());
					ctrl.addEmployee(emp);
					break;
				case 2:viewAll(ctrl.viewAllEmp());
					break;
				case 3:System.out.println("Enter the emp ID");
				ctrl.getEmployeeById(Integer.parseInt(br.readLine()));
				break;
				case 4:System.out.println("Enter the emp ID");
				ctrl.deleteEmployee(Integer.parseInt(br.readLine()));
				break;
				default:System.exit(1);
			}
		
		}while(true);
	}

	private void viewAll(HashMap<Integer, Employee> viewAllEmp) {

		
		Set<Entry<String,String>> set= emp.entrySet();
		
		set.stream().forEach((element)->System.out.println(element.getValue()+" "+element.getKey()));
	}
}