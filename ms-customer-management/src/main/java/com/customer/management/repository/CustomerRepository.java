package com.customer.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
