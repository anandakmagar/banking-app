package com.learning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.entity.FundTransfer;


@Service
public interface AccountService {
	
	public Account createAccount(Long id, Account account);
    public Account approveAccount(Long accountnumber, Account account);
    public List<Account> findAccountsByCustomerId(Long customerId);
	public FundTransfer transferFund(FundTransfer fundTransfer);
	//public Statement getStatementByAccountNumber(Long accountNumber);
}
