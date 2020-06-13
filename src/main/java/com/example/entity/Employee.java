package com.example.entity;

import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Version;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "empcontainer",ru = "400")
public class Employee {
	
	@Id
    private String id;
	
    private String firstName;

    private String lastName;
    
    private Long salary;
    
    @PartitionKey
    private String region;
    
	/*
	 * @Version private String _etag;
	 */

}
