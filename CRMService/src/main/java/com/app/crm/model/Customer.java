package com.app.crm.model;

import com.app.crm.enums.LoanEnums;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerDateOfBirth;
	private int customerAge;
	private int requiredTenure;
	private String gender;
	private String customerEmail;
	private long cutomerMobileNumber;
	private long customerAdditionalMobileNumber;
	private double customerAmmountPaidForCarloan;
	private double customerTotalLoanRequiredAmmount;
	
	
	@Enumerated(EnumType.STRING)
	private LoanEnums loanEnums;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocuments allPersonalDocuments;
	
	@OneToOne(cascade = CascadeType.ALL)
	private DependantInformation dependantInformation;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private MedicalInfo medicalInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cibil;

	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetails previousLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails accountDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
}
