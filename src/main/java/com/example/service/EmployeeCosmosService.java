package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.data.cosmos.PartitionKey;
import com.example.entity.Employee;
import com.example.repo.EmployeeCosmosRepository;

@Service
public class EmployeeCosmosService {

	@Autowired
	private EmployeeCosmosRepository employeeCosmosRepository;

	public List<Employee> getAllEmployees() {
		Iterable<Employee> employeeIterable = employeeCosmosRepository.findAll();
		List<Employee> employees = (List<Employee>) employeeIterable;
		return employees;
	}

	public List<Employee> getEmployeesByPartitionKey(String partitionKey) {
		return employeeCosmosRepository.findAll(new PartitionKey(partitionKey));
	}

	public Employee getEmployeeByPartitionKey(String id, String partitionKey) {
		return employeeCosmosRepository.findById(id, new PartitionKey(partitionKey))
				.orElseThrow(() -> new RuntimeException("Employee not found with id=" + id));
	}

	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeCosmosRepository.save(employee);
		return savedEmployee;
	}

	public void deleteEmployee(String id, String partitionKey) {
		employeeCosmosRepository.deleteById(id, new PartitionKey(partitionKey));
	}
}
