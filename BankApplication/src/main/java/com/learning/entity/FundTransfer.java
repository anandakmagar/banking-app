package com.learning.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class FundTransfer {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long fundTransferId;

    private long fromAccNumber;
    private long toAccNumber;
    private long amount;
    private String reason;
    private long byCustomerId;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateOfCreation;
	
	@PrePersist
	private void onCreate() {
		dateOfCreation = new Date();
	}
	
	@ManyToOne
	@JoinColumn(name = "customer", nullable = true)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "account", nullable = true)
	private Account account;

	public FundTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundTransfer(long fundTransferId, long fromAccNumber, long toAccNumber, long amount, String reason,
			long byCustomerId, Date dateOfCreation, Customer customer, Account account) {
		super();
		this.fundTransferId = fundTransferId;
		this.fromAccNumber = fromAccNumber;
		this.toAccNumber = toAccNumber;
		this.amount = amount;
		this.reason = reason;
		this.byCustomerId = byCustomerId;
		this.dateOfCreation = dateOfCreation;
		this.customer = customer;
		this.account = account;
	}

	public long getFundTransferId() {
		return fundTransferId;
	}

	public void setFundTransferId(long fundTransferId) {
		this.fundTransferId = fundTransferId;
	}

	public long getFromAccNumber() {
		return fromAccNumber;
	}

	public void setFromAccNumber(long fromAccNumber) {
		this.fromAccNumber = fromAccNumber;
	}

	public long getToAccNumber() {
		return toAccNumber;
	}

	public void setToAccNumber(long toAccNumber) {
		this.toAccNumber = toAccNumber;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getByCustomerId() {
		return byCustomerId;
	}

	public void setByCustomerId(long byCustomerId) {
		this.byCustomerId = byCustomerId;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "FundTransfer [fundTransferId=" + fundTransferId + ", fromAccNumber=" + fromAccNumber + ", toAccNumber="
				+ toAccNumber + ", amount=" + amount + ", reason=" + reason + ", byCustomerId=" + byCustomerId
				+ ", dateOfCreation=" + dateOfCreation + ", customer=" + customer + ", account=" + account + "]";
	}
	
	
	
}