package com.keshri.company.companyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshri.company.companyservice.feignConfig.FeignClients;
import com.keshri.company.companyservice.model.Company;
import com.keshri.company.companyservice.model.Employee;

@RestController
public class CompanyController {

	@Autowired
	FeignClients.EmployeeClient employeeClient;

	@GetMapping("/say")
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<>("Hello Company", HttpStatus.OK);
	}

	@GetMapping("/company")
	public ResponseEntity<Company> getCompany() {
		Company company = new Company();
		company.setId(1);
		company.setName("MuSigma");
		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	@GetMapping("/companyandaddress")
	public ResponseEntity<Company> getCompanyWithAddress() {
		Company company = new Company();
		company.setId(1);
		company.setName("MuSigma");
		ResponseEntity<Employee> response = employeeClient.getEmployee();
		company.setEmployee(response.getBody());
		return new ResponseEntity<>(company, HttpStatus.OK);
	}

}
