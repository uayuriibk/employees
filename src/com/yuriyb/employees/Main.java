package com.yuriyb.employees;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	// Exceptions handling should be present
	// Logger should be used
	public static void main(String[] args) {

		String fileName = "C://file.dat";
		List<Employee> collection = new ArrayList<Employee>();
		
		ReadingWritingEmployees rwe = new ReadingWritingEmployees();
		
		collection.add(new Engineer("Mickey Mouse", 2001.00));
		collection.add(new Engineer("Donald Duck", 2000.00));
		collection.add(new Engineer("Goofy Dog", 3000.00));
		collection.add(new ShiftEngineer("Robin Good", 15.00));
		collection.add(new ShiftEngineer("Hary Potter", 13.00));
		
		try {
			rwe.writeEmployeesIntoFile(collection, fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			rwe.readEmployeesFromFile(fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for (Employee e: collection)
			System.out.println(e.getName()+" "+e.getSalary());
		
		System.out.println(" ");
		
		ComparisonByWageName gs = new ComparisonByWageName();
		
		Collections.sort(collection, gs);
		
		for (Employee e: collection)
			System.out.println(e.getName()+" "+e.getSalary());
		
	}
}

class ComparisonByWageName implements Comparator<Employee>{
	
	public int compare(Employee one, Employee two){
		
		if (one.getSalary()==two.getSalary()){
			return one.getName().compareTo(two.getName());
		}
		else
			if (one.getSalary()>two.getSalary()) return 1;
		else
			return -1;
	}
}
