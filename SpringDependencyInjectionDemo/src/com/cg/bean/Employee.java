package com.cg.bean;

public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	private int id;
	private String name;
	
	public static int empID;
	
	static
	{
		empID=200;
	}
	
	public static int fetchNextID()
	{
		empID++;
		return empID;
	}
	
	public Employee(int id,String name)
	{
		this.id=id;
		this.name=name;
	}

}
