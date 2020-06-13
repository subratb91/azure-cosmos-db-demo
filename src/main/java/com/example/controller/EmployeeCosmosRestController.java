package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeCosmosService;

@RestController
@RequestMapping("api/employees")
public class EmployeeCosmosRestController {
	
	@Autowired
	private EmployeeCosmosService employeeCosmosService;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeCosmosService.getAllEmployees();
	}
	
	@GetMapping("/bypartitionkey/{partitionKey}")
	public List<Employee> getEmployeesByPartitionKey(@PathVariable String partitionKey) {
		return employeeCosmosService.getEmployeesByPartitionKey(partitionKey);
	}
	
	@GetMapping("/bypartitionkeyandid/{partitionKey}/{id}")
	public Employee getEmployeeByPartitionKeyAndId(@PathVariable String partitionKey, @PathVariable String id) {
		return employeeCosmosService.getEmployeeByPartitionKey(id, partitionKey);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeCosmosService.saveEmployee(employee);
	}
	
	@DeleteMapping("/bypartitionkeyandid/{partitionKey}/{id}")
	public void deleteEmployee(@PathVariable String partitionKey, @PathVariable String id) {
		employeeCosmosService.deleteEmployee(id, partitionKey);
	}
	
}
