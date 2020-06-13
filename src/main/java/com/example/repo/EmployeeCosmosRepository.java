package com.example.repo;

import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

@Repository
public interface EmployeeCosmosRepository extends CosmosRepository<Employee, String> {

}
