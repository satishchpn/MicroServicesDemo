package com.keshri.employee.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshri.employee.employeeservice.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/say")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<>("Hello Employee", HttpStatus.OK);
	}

	@GetMapping("/employee")
	public ResponseEntity<Employee> getEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Satish Keshri");
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
