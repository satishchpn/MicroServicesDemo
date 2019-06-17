package com.keshri.company.companyservice.feignConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.keshri.company.companyservice.model.Employee;

public class FeignClients {

	@FeignClient("${my.microservices.employee.name}")
	public interface EmployeeClient {

		@GetMapping("/employee")
		ResponseEntity<Employee> getEmployee();

	}
}
