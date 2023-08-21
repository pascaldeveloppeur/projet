package com.moriset.employee.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.moriset.employee.model.Employee;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void shouldSaveEmployeeSuccessfully() {
		
		Employee employee = new Employee();
				
				employee.setFirstName("pascal");
				employee.setLastName("yakou");
				employee.setEmail("pascal@gmail.com");
				employee.setPassword("1254");
				
				
				Employee empl1 = employeeService.saveEmployee(employee);
				assertNotNull(empl1);
				assertEquals(empl1.getFirstName(),employee.getFirstName());
		
	}

}
