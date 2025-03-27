package com.app.crm.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.crm.model.Customer;

public interface CustomerService {
	public Customer saveCustomerDetails(String customer, MultipartFile addressProof, MultipartFile panCard,
			MultipartFile incomeTax, MultipartFile adharCard, MultipartFile photo, MultipartFile signature,
			MultipartFile bankCheque, MultipartFile salarySlip);

	public Customer saveCustomerDetails(Customer c);

}
