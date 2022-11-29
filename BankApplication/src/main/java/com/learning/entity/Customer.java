package com.learning.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table
@CrossOrigin
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long ssn;
	private String email;
	private String phoneNumber;
	private String address;
	private String fullName;
	private String username;
	private String password;
	private UserRoleType userRoleType = UserRoleType.CUSTOMER;
	private String status;
	private CustomerStatusType customerStatusType;
	private String securityQuestionAnswer;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateOfCreation;
	
	@PrePersist
	private void onCreate() {
		dateOfCreation = new Date();
	}
	
	@OneToMany(mappedBy = "customer")
	private List<FundTransfer> fundTransfers = new ArrayList<FundTransfer>();
	
	@OneToMany(mappedBy = "customer")
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();

	@ManyToOne
	@JoinColumn(name = "account", nullable = true)
	private Customer customer;
	
	
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts = new ArrayList<Account>();
	
	@OneToMany(mappedBy = "transaction")
	private List<Transaction> transaction = new ArrayList<Transaction>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, Long ssn, String email, String phoneNumber, String address, String fullName,
			String username, String password, UserRoleType userRoleType, String status,
			CustomerStatusType customerStatusType, String securityQuestionAnswer, Date dateOfCreation,
			List<FundTransfer> fundTransfers, List<Beneficiary> beneficiaries, Customer customer,
			List<Account> accounts, List<Transaction> transaction) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.userRoleType = userRoleType;
		this.status = status;
		this.customerStatusType = customerStatusType;
		this.securityQuestionAnswer = securityQuestionAnswer;
		this.dateOfCreation = dateOfCreation;
		this.fundTransfers = fundTransfers;
		this.beneficiaries = beneficiaries;
		this.customer = customer;
		this.accounts = accounts;
		this.transaction = transaction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public UserRoleType getUserRoleType() {
		return userRoleType;
	}

	public void setUserRoleType(UserRoleType userRoleType) {
		this.userRoleType = userRoleType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerStatusType getCustomerStatusType() {
		return customerStatusType;
	}

	public void setCustomerStatusType(CustomerStatusType customerStatusType) {
		this.customerStatusType = customerStatusType;
	}

	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", ssn=" + ssn + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", fullName=" + fullName + ", username=" + username + ", password="
				+ password + ", userRoleType=" + userRoleType + ", status=" + status + ", customerStatusType="
				+ customerStatusType + ", securityQuestionAnswer=" + securityQuestionAnswer + ", dateOfCreation="
				+ dateOfCreation + ", fundTransfers=" + fundTransfers + ", beneficiaries=" + beneficiaries
				+ ", customer=" + customer + ", accounts=" + accounts + ", transaction=" + transaction + "]";
	}
	
	
}
