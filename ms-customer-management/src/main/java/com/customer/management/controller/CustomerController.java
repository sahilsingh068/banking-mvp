package com.customer.management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.model.Customer;
import com.customer.management.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@PostMapping(value = "/addCustomer")
	public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer) {
		var addCustomer = customerService.addCustomer(customer);
		return ResponseEntity.ok(addCustomer);
	}
	@GetMapping(value = "/getCustomer/{customerId}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable String customerId) {
		var singleCustomer = customerService.fetchCustomer(customerId);
		return ResponseEntity.ok(singleCustomer);
	}
	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<List<Customer>> fetchAllCustomers() {
		List<Customer> fetchAllCustomers = customerService.getAllCustomer();
		return ResponseEntity.ok(fetchAllCustomers);
	}
	@DeleteMapping(value = "/deleteCustomer/{customerId}")
	public void deleteCustomers(@PathVariable String customerId) {
		 customerService.deleteCustomer(customerId);
	}
	@PutMapping(value = "/updateCustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable String customerId) {
		customer.setCustomerId(customerId);
		var updatedCustomer = customerService.updateCustomer(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

}
