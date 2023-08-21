package com.moriset.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moriset.employee.model.Employee;
import com.moriset.employee.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8084")
@RequestMapping("/api")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees(){
		return employeeService.getEmployee();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee empl = employeeService.saveEmployee(new Employee(employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getPassword()));
		return new ResponseEntity<>(empl,HttpStatus.CREATED) ;
	}

}
