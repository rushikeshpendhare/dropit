package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.IemployeeDAO;
import com.nit.model.Employee;

import lombok.NonNull;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private IemployeeDAO empDao;

	@Override
	public List<Employee> getAllEmployee(String deg1, String deg2, String deg3) throws Exception {

		return empDao.getEmployeeByDesg(deg1, deg2, deg3);
	}

	@Override
	public List<String> getAllEmployeeName(String deg1, String deg2, String deg3) throws Exception {
		List<Employee> emp = empDao.getEmployeeByDesg(deg1, deg2, deg3);
		List<@NonNull String> list = emp.stream().map(x -> x.getEname()).toList();
		return list;
	}

	@Override
	public boolean updateEmployee(int id, double salary) throws Exception {

		boolean exist = empDao.isExist(id);
		if (exist) {
			empDao.updateEmployeeSalary(id, salary);
		}
		return false;
	}

	@Override
	public String delEmployee(int id) throws Exception 
	{
	    int result = empDao.deleteEmployee(id);	
		return result==0 ?"Employee not deleted " : "Employee Deleted Succesfully";
	}
}
