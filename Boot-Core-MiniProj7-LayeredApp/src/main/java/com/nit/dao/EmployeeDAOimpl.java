package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("empDAO")
public class EmployeeDAOimpl implements IemployeeDAO {
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmployeeByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> empList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement("select * from my_emp where desg in (?,?,?)")) {
				pst.setString(1, desg1);
				pst.setString(2, desg2);
				pst.setString(3, desg3);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getDouble(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(8));
					empList.add(emp);
				}
			} catch (SQLException e) {
				throw new RuntimeException("Data fetching problem : " + e.getMessage());
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Connection problem : " + ex.getMessage());
		}

		return empList;
	}

	@Override
	public void updateEmployeeSalary(int id, Double salary) throws Exception {

		try (Connection con = ds.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement("update my_emp set salary = ? where empid = ?")) {
				pst.setDouble(1, salary);
				pst.setInt(2, id);

				pst.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Data fetching problem : " + e.getMessage());
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Connection problem : " + ex.getMessage());
		}

	}

	@Override
	public boolean isExist(int id) throws Exception {
		boolean flag = false;

		try (Connection con = ds.getConnection()) {
			try (PreparedStatement pst = con.prepareStatement("select empname from my_emp where empid=?")) {

				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					flag = true;
				}
			} catch (SQLException e) {
				throw new RuntimeException("Data fetching problem : " + e.getMessage());
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Connection problem : " + ex.getMessage());
		}
		return flag;
	}

	@Override
	public int deleteEmployee(int id) throws Exception
	{
		int result = 0;
		try(Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement("delete from my_emp where empid = ?"))
		{
			ps.setInt(1, id);
			
			result = ps.executeUpdate();
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return result;
		
	}

}
