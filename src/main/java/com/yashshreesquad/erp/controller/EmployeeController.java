package com.yashshreesquad.erp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yashshreesquad.erp.model.Employee;
import com.yashshreesquad.erp.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{empId}")
	public Optional<Employee> getEmployeeWithID(@PathVariable Long empId){
		return employeeRepository.findById(empId);
	}

	@PostMapping("/employees")
	public Optional<Employee> saveEmployeeDetails(@RequestBody Employee employee){
		return Optional.of(employeeRepository.save(employee));
	}

}
