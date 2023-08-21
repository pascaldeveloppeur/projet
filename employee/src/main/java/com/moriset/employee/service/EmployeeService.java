package com.moriset.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriset.employee.model.Employee;
import com.moriset.employee.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Optional<Employee> getEmployee(final Long id){
		return employeeRepo.findById(id);
	}
	
	public Iterable<Employee> getEmployee(){
		return employeeRepo.findAll();
	}
	
	public void deleteEmployee(final Long id) {
		employeeRepo.deleteById(id);
	}
	
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepo.save(employee);
		return savedEmployee;
	}

}
