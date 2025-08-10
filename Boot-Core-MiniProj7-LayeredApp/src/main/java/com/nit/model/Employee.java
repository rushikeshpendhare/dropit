package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	private int empid;
	
	@NonNull
	private String ename;
	@NonNull
	private String desg;
	@NonNull
	private String job;
	@NonNull
	private Double salary;
	private int deptno;
	private double grossSalary;
	private double netsalary;

}
