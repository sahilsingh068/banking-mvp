package com.account.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	@Column(name = "accnum")
	private String accountId;
	
	private Double amount;
	
	@Column(name = "custid")
	private String customerId;

	//@OneToOne
	@Transient
	private Customer customer;

}
