package com.account.management.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.account.management.model.Customer;

@FeignClient(value = "${microservice.customer}")
public interface CustomerAPIFeignClient {
	
	@DeleteMapping(value = "/deleteCustomer/{customerId}")
	public void deleteCustomers(@PathVariable("customerId") String customerId);
	
	@GetMapping(value = "/customers/getCustomer/{customerId}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable("customerId") String customerId);
	
	@GetMapping(value = "/getCustomer/{customerId")
	public Customer getCustomer(@PathVariable("customerId") String customerId);

}
