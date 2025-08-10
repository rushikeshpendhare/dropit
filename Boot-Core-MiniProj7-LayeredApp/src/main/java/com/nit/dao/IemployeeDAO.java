package com.nit.dao;

import java.util.List;

import com.nit.model.Employee;

public interface IemployeeDAO {
	
	public boolean isExist(int id)throws Exception;
	
	public List<Employee> getEmployeeByDesg(String desg1 ,String desg2 , String desg3) throws Exception;
	
	public void updateEmployeeSalary(int id, Double salary) throws Exception;
	
	
	public int deleteEmployee(int id) throws Exception;

}
