package com.yuriyb.employees;

import java.io.Serializable;

//Exceptions handling should be present
// Logger should be used

/**
 *
 */
abstract class Employee implements Serializable {
	
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 5697464329933968962L;
	private int id;
	private String name;
	private static int nextId = 1;
	
	Employee(String name){
		this.name = name;
		this.setId(nextId++);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	abstract double getSalary();
	
	public String getName(){
		return name;
	}
}

class Engineer extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2421514717019833095L;
	private double salary;
	
	Engineer (String name, double salary){
		super(name);
		this.salary = salary;
	}
	
	double getSalary(){
		return salary;
	}
}

class ShiftEngineer extends Employee {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3546090705720788106L;
	private double hourRate;
	
	ShiftEngineer(String name, double hourRate){
		super(name);
		this.hourRate = hourRate;
	}
	
	double getSalary(){
		return hourRate*20.8*8;
	}
}