package com.nit.service;

import java.util.List;

import com.nit.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee(String deg1, String deg2, String deg3) throws Exception;
	public List<String> getAllEmployeeName(String deg1, String deg2, String deg3) throws Exception;
	
	public boolean updateEmployee(int id, double salary) throws Exception;
	
	public String delEmployee(int id) throws Exception;

}
