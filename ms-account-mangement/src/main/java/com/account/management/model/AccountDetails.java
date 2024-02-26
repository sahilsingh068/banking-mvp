package com.account.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class AccountDetails {

	@Id
	private String accountId;

	private Double amount;
	
    private String customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	public AccountDetails(Account account, Customer customer) {
		this.accountId = account.getAccountId();
		this.amount = account.getAmount();
		this.customerId = customer.getCustomerId();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getFirstName();
		this.email = customer.getEmail();
		this.phone = customer.getPhone();
		this.address = customer.getAddress();
	}

}
