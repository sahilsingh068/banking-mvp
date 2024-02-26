package com.customer.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.customer.management.model.Customer;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.service.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerReposiotry;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerReposiotry.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer fetchCustomer = customerReposiotry.findById(customer.getCustomerId()).get();
		fetchCustomer.setFirstName(customer.getFirstName());
		fetchCustomer.setLastName(customer.getLastName());
		fetchCustomer.setEmail(customer.getEmail());
		fetchCustomer.setAddress(customer.getAddress());
		fetchCustomer.setPhone(customer.getPhone());
		Customer updatedCustomer = customerReposiotry.save(fetchCustomer);
		return updatedCustomer;
		
	}

	@Override
	public Customer fetchCustomer(String customerId) {
		Optional<Customer> customer = customerReposiotry.findById(customerId);
		return customer.get();
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customersList = customerReposiotry.findAll();
		return customersList;
	}

	@Override
	public void deleteCustomer(String customerId) {
		customerReposiotry.deleteById(customerId);
	}

}
