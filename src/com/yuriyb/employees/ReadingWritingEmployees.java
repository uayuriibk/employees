package com.yuriyb.employees;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//Exceptions handling should be present
// Logger should be used
// Java doc should be present

public class ReadingWritingEmployees {
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	List<Employee> collection;
	
	@SuppressWarnings("unchecked")
	public void readEmployeesFromFile(String fileName) {
		
		collection = new ArrayList<Employee>();
		
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			collection = (List<Employee>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("The collection has been read from the file!");
		
		try {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeEmployeesIntoFile(List<Employee> collection, String fileName) throws FileNotFoundException, IOException{
		oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(collection);
		System.out.println("The collection has been written into the file!");
		oos.close();
	}
}
