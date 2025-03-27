package com.app.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.crm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
