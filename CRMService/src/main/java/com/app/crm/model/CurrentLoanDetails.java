package com.app.crm.model;

import java.time.LocalDateTime;

import com.app.crm.enums.LoanStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class CurrentLoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int currentLoanId;
	private int currentLoanNo;
	@OneToOne(cascade = CascadeType.ALL)
	private EMIDetails emiDetails;
	private double loanAmount;
	private int rateOfIntrest;
	private int tenure;
	private double totalAmountToBePaid;
	private int processingFees;
	private double totalIntrest;
	private LocalDateTime sanctionDate;
	private String remark;
	private LoanStatus status;
	
}
