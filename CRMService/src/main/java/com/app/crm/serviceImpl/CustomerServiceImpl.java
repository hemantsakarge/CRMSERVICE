package com.app.crm.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.crm.model.AllPersonalDocuments;
import com.app.crm.model.Customer;
import com.app.crm.repository.CustomerRepository;
import com.app.crm.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomerDetails(String customer, MultipartFile addressProof, MultipartFile panCard,
			MultipartFile incomeTax, MultipartFile adharCard, MultipartFile photo, MultipartFile signature,
			MultipartFile bankCheque, MultipartFile salarySlip) {
		Customer savecustomer = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			savecustomer = mapper.readValue(customer, Customer.class);
			AllPersonalDocuments doc = new AllPersonalDocuments();
			doc.setAddressProof(addressProof.getBytes());
			doc.setPanCard(panCard.getBytes());
			doc.setIncomeTax(incomeTax.getBytes());
			doc.setAdharCard(adharCard.getBytes());
			doc.setPhoto(photo.getBytes());
			doc.setSignature(signature.getBytes());
			doc.setBankCheque(bankCheque.getBytes());
			doc.setSalarySlip(salarySlip.getBytes());

			savecustomer.setAllPersonalDocuments(doc);
			customerRepository.save(savecustomer);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mailMessage;
		try {
			mailMessage = new MimeMessageHelper(message, true);
			mailMessage.setFrom("rahuljadhao1904@gmail.com"); 
			mailMessage.setTo(savecustomer.getCustomerEmail());
			mailMessage.setSubject("Regarding Customer Registry");
			mailMessage.setText("Dear " + savecustomer.getCustomerName() + ", your registration is successful!");
			mailMessage.addAttachment(addressProof.getOriginalFilename(), addressProof);
			mailMessage.addAttachment(panCard.getOriginalFilename(), panCard);
			mailMessage.addAttachment(adharCard.getOriginalFilename(), adharCard);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		Customer customers = new Customer();
		customers.setCustomerId(savecustomer.getCustomerId());
		customers.setCustomerName(savecustomer.getCustomerName());
		customers.setCustomerDateOfBirth(savecustomer.getCustomerDateOfBirth());
		customers.setCustomerAge(savecustomer.getCustomerAge());
		customers.setCustomerEmail(savecustomer.getCustomerEmail());
		customers.setGender(savecustomer.getGender());
		customers.setRequiredTenure(savecustomer.getRequiredTenure());
		customers.setCustomerAddress(savecustomer.getCustomerAddress());
		customers.setCutomerMobileNumber(savecustomer.getCutomerMobileNumber());
		customers.setCustomerAdditionalMobileNumber(savecustomer.getCustomerAdditionalMobileNumber());
		customers.setCustomerAmmountPaidForCarloan(savecustomer.getCustomerAmmountPaidForCarloan());
		customers.setCustomerTotalLoanRequiredAmmount(savecustomer.getCustomerTotalLoanRequiredAmmount());
		customers.setDependantInformation(savecustomer.getDependantInformation());
		customers.setCustomerAddress(savecustomer.getCustomerAddress());
		customers.setMedicalInfo(savecustomer.getMedicalInfo());
		customers.setCibil(savecustomer.getCibil());
		customers.setPreviousLoanDetails(savecustomer.getPreviousLoanDetails());
		customers.setAccountDetails(savecustomer.getAccountDetails());
		customers.setGuarantorDetails(savecustomer.getGuarantorDetails());

		return customers;
	}

	@Override
	public Customer saveCustomerDetails(Customer c) {
		Customer customer = customerRepository.save(c);
		return customer;
	}
}
