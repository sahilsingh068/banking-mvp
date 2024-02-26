package com.account.management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;

}
