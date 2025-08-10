package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.service.EmployeeService;
import com.nit.service.EmployeeServiceImpl;

@SpringBootApplication
public class BootCoreMiniProj7LayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootCoreMiniProj7LayeredAppApplication.class, args);
		EmployeeService service = ctx.getBean(EmployeeServiceImpl.class);

		try {
			System.out.println(service.getAllEmployee("EMPLOYEE", "MANAGER", "SALESMAN"));

			boolean update = service.updateEmployee(101, 55000d);
			if (update) {
				System.out.println("Update successfully");
			} else {
				System.out.println("Invalid id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}// hhhh

	}

}
