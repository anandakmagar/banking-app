package com.learning.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
@CrossOrigin
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long accountNumber;
	private Long customerId;
	private AccountTypes accountTypes;
	private double accountBalance = 0;
	private AccountStatusType accountStatusType = AccountStatusType.DISABLED;
	private String approvalStatus = "No";
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateOfCreation;
	
	@PrePersist
	private void onCreate() {
		dateOfCreation = new Date();
	}
	
	@ManyToOne
	@JoinColumn(name = "account", nullable = true)
	private Customer customer;
	
	@OneToMany(mappedBy = "account")
	private List<FundTransfer> fundTransfers = new ArrayList<FundTransfer>();

	@ManyToMany
	@JoinTable(name = "accountBeneficiary",
	joinColumns = {
			@JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "beneficiaryAccountNumber", referencedColumnName = "beneficiaryAccountNumber")
	}
	)
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long accountNumber, Long customerId, AccountTypes accountTypes, double accountBalance,
			AccountStatusType accountStatusType, String approvalStatus, Date dateOfCreation, Customer customer,
			List<FundTransfer> fundTransfers, List<Beneficiary> beneficiaries) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.accountTypes = accountTypes;
		this.accountBalance = accountBalance;
		this.accountStatusType = accountStatusType;
		this.approvalStatus = approvalStatus;
		this.dateOfCreation = dateOfCreation;
		this.customer = customer;
		this.fundTransfers = fundTransfers;
		this.beneficiaries = beneficiaries;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public AccountTypes getAccountTypes() {
		return accountTypes;
	}

	public void setAccountTypes(AccountTypes accountTypes) {
		this.accountTypes = accountTypes;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public AccountStatusType getAccountStatusType() {
		return accountStatusType;
	}

	public void setAccountStatusType(AccountStatusType accountStatusType) {
		this.accountStatusType = accountStatusType;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<FundTransfer> getFundTransfers() {
		return fundTransfers;
	}

	public void setFundTransfers(List<FundTransfer> fundTransfers) {
		this.fundTransfers = fundTransfers;
	}

	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerId=" + customerId + ", accountTypes="
				+ accountTypes + ", accountBalance=" + accountBalance + ", accountStatusType=" + accountStatusType
				+ ", approvalStatus=" + approvalStatus + ", dateOfCreation=" + dateOfCreation + ", customer=" + customer
				+ ", fundTransfers=" + fundTransfers + ", beneficiaries=" + beneficiaries + "]";
	}
	
	
	
}
