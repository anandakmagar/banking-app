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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table
@CrossOrigin
public class Beneficiary {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long beneficiaryAccountNumber;
	private Long customerId;
	private Long accountNumber;
	private AccountTypes accountTypes;
	private String fullName;
	private Long ssn;
	private String phoneNumber;
	private String approvalStatus = "No";
	private String address;
	private String username;
	private String password;
	private BeneficiaryStatusType beneficiaryStatusType;
	private UserRoleType userRoleType = UserRoleType.BENEFICIARY;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateOfCreation;
	
	@PrePersist
	private void onCreate() {
		dateOfCreation = new Date();
	}

	@ManyToMany(mappedBy = "beneficiaries")
	private List<Account> accounts = new ArrayList<Account>();
	
	@ManyToOne
	@JoinColumn(name = "customer", nullable = true)
	private Customer customer;

	public Beneficiary() {
		super();
	}

	public Beneficiary(Long beneficiaryAccountNumber, Long customerId, Long accountNumber, AccountTypes accountTypes,
			String fullName, Long ssn, String phoneNumber, String approvalStatus, String address, String username,
			String password, BeneficiaryStatusType beneficiaryStatusType, UserRoleType userRoleType,
			Date dateOfCreation, List<Account> accounts, Customer customer) {
		super();
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountTypes = accountTypes;
		this.fullName = fullName;
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		this.approvalStatus = approvalStatus;
		this.address = address;
		this.username = username;
		this.password = password;
		this.beneficiaryStatusType = beneficiaryStatusType;
		this.userRoleType = userRoleType;
		this.dateOfCreation = dateOfCreation;
		this.accounts = accounts;
		this.customer = customer;
	}

	public Long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(Long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountTypes getAccountTypes() {
		return accountTypes;
	}

	public void setAccountTypes(AccountTypes accountTypes) {
		this.accountTypes = accountTypes;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BeneficiaryStatusType getBeneficiaryStatusType() {
		return beneficiaryStatusType;
	}

	public void setBeneficiaryStatusType(BeneficiaryStatusType beneficiaryStatusType) {
		this.beneficiaryStatusType = beneficiaryStatusType;
	}

	public UserRoleType getUserRoleType() {
		return userRoleType;
	}

	public void setUserRoleType(UserRoleType userRoleType) {
		this.userRoleType = userRoleType;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Beneficiary [beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", customerId=" + customerId
				+ ", accountNumber=" + accountNumber + ", accountTypes=" + accountTypes + ", fullName=" + fullName
				+ ", ssn=" + ssn + ", phoneNumber=" + phoneNumber + ", approvalStatus=" + approvalStatus + ", address="
				+ address + ", username=" + username + ", password=" + password + ", beneficiaryStatusType="
				+ beneficiaryStatusType + ", userRoleType=" + userRoleType + ", dateOfCreation=" + dateOfCreation
				+ ", accounts=" + accounts + ", customer=" + customer + "]";
	}

	
	
}
