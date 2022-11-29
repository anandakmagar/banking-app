package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Account;
import com.learning.entity.FundTransfer;
import com.learning.repository.AccountRepository;
import com.learning.service.AccountService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;
	@Autowired
	AccountRepository accountRepository;
	
	@PostMapping("/customer/{id}/account")
	public Account createAccount(@PathVariable("id") Long id, @RequestBody Account account) {
		return accountService.createAccount(id, account);
	}	
	
    @PutMapping("/customer/account/{accountnumber}")
    public Account approveAccount(@PathVariable("accountnumber") Long accountnumber,
                                       @RequestBody Account account){
        return accountService.approveAccount(accountnumber, account);
    }
    
	@GetMapping("/customer/{customerid}/account")
	public List<Account> findAccountsByCustomerId(@PathVariable("customerid") Long customerid) {
		return accountService.findAccountsByCustomerId(customerid);
	}
	
	@PostMapping("/transfer")
	public FundTransfer transferFund(@RequestBody FundTransfer fundTransfer) {
		return accountService.transferFund(fundTransfer);
	}
    
}
