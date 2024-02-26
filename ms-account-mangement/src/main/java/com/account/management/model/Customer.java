package com.account.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	private String customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String address;
	
}
