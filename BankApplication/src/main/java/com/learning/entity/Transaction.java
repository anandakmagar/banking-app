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
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionNumber;
	private TransactionType transactionType;
	private double amount;

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
	@JoinColumn(name = "transaction", nullable = true)
	private Transaction transaction;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transactionNumber, TransactionType transactionType, double amount, Date dateOfCreation,
			Customer customer, Transaction transaction) {
		super();
		this.transactionNumber = transactionNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateOfCreation = dateOfCreation;
		this.customer = customer;
		this.transaction = transaction;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Transaction [transactionNumber=" + transactionNumber + ", transactionType=" + transactionType
				+ ", amount=" + amount + ", dateOfCreation=" + dateOfCreation + ", customer=" + customer
				+ ", transaction=" + transaction + "]";
	}
	
	
	
	
}