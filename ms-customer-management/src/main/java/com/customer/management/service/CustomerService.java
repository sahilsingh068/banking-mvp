package com.customer.management.service;

import java.util.List;

import com.customer.management.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer fetchCustomer(String customerId);
	List<Customer> getAllCustomer();
	void deleteCustomer(String customerId);

}
