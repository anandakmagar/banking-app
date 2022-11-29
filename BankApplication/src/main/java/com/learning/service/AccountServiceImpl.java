package com.learning.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.entity.FundTransfer;
import com.learning.repository.AccountRepository;
import com.learning.repository.CustomerRepository;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Account createAccount(Long id, Account account) {
		if(customerRepository.existsById(id)) {
			account.setCustomerId(id);
			accountRepository.save(account);
		}
		return account;
	}
	
	@Override
	public Account approveAccount(Long accountnumber, Account account) {
        Account account1 = accountRepository.findById(accountnumber).get();

        if(Objects.nonNull(account.getAccountNumber())){
            account1.setAccountNumber(account.getAccountNumber());
        }

        if(Objects.nonNull(account.getApprovalStatus())){
            account1.setApprovalStatus(account.getApprovalStatus());
        }
        return accountRepository.save(account1);
	}
	
	@Override
	public List<Account> findAccountsByCustomerId(Long customerId) {
		var accounts = (List<Account>) accountRepository.findAccountsByCustomerId(customerId);
		return accounts;
	}

	@Override
	public FundTransfer transferFund(FundTransfer fundTransfer) {
		long fromAccNumber = fundTransfer.getFromAccNumber();
		long toAccNumber = fundTransfer.getToAccNumber();
	   	 //checks if both accounts exist
	   	 if(accountRepository.findById(fromAccNumber).isPresent()
	   			 && accountRepository.findById(toAccNumber).isPresent()){
	   		 //Account fromAcc = accountRepository.getById(fromAccNumber);
	   		 Account fromAcc = accountRepository.findById(fromAccNumber).get();
	   		 //Account toAcc = accountRepository.getById(toAccNumber);
	   		 Account toAcc = accountRepository.findById(toAccNumber).get();
	   		 
	   		 double amountTransfer = fundTransfer.getAmount();
	   		 
	   		 fromAcc.setAccountBalance(fromAcc.getAccountBalance() - amountTransfer);
	   		 toAcc.setAccountBalance(toAcc.getAccountBalance() + amountTransfer);
	   		 
	   		 accountRepository.save(fromAcc);
	   		 accountRepository.save(toAcc);
	   	 }
	   	 
	   	 return fundTransfer;
	}

//	@Override
//	public Statement getStatementByAccountNumber(Long accountNumber) {
//		if(accountRepository.existsById(accountNumber)) {
//			//accountNumber
//			//customerName
//			//balance
//			Statement statement = new Statement();
//			statement.setAccountNumber(accountNumber);
//			statement.setCustomerName();
//			
//		}
//		return null;
//	}
	

}
