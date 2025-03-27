package com.app.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.crm.model.Customer;
import com.app.crm.model.DependantInformation;
import com.app.crm.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> onSaveCustomerDetails(@RequestPart("customer") String customer,
			@RequestPart("addressProof") MultipartFile addressProof, @RequestPart("panCard") MultipartFile panCard,
			@RequestPart("incomeTax") MultipartFile incomeTax, @RequestPart("adharCard") MultipartFile adharCard,
			@RequestPart("photo") MultipartFile photo, @RequestPart("signature") MultipartFile signature,
			@RequestPart("bankCheque") MultipartFile bankCheque, @RequestPart("salarySlip") MultipartFile salarySlip) {

		
		Customer savecustomer = customerService.saveCustomerDetails(customer, addressProof, panCard, incomeTax,
				adharCard, photo, signature, bankCheque, salarySlip);
		
		
		return new ResponseEntity<Customer>(savecustomer, HttpStatus.CREATED);
	}
	
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Customer> onSaveCustomerDetails(@RequestBody Customer c)
	{
			
		Customer saveCustomer = customerService.saveCustomerDetails(c);
		return new ResponseEntity<Customer>(saveCustomer, HttpStatus.CREATED);
	}
}
