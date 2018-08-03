package com.cg.bean;

public class Employee {

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
