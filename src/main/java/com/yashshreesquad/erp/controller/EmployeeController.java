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

	@PatchMapping("/employees/{empId}")
	public Optional<Employee> updateEmployeeDetails(@RequestBody Employee employee, @PathVariable Long empId){
		Optional<Employee> employeeData = employeeRepository.findById(empId);
		employeeData.ifPresent( e1 ->{
			if (employee.getFirstName() != null) {
				e1.setFirstName(employee.getFirstName());
			}
			if (employee.getLastName() != null) {
				e1.setLastName(employee.getLastName());
			}
			if (employee.getEmailID() != null) {
				e1.setEmailID(employee.getEmailID());
			}
			employeeRepository.save(e1);
		});
		return getEmployeeWithID(empId);
	}

}
