package com.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.entity.Customer;

@Service
public interface CustomerService {
	public Customer registerCustomer(Customer user);
	//public Optional<Account> displayAccounts(Long id, Customer customer);
//	public List<Account> findAccountsByCustomerId(Long customerid);
	public Customer findCustomerById(Long id);
	public Customer updateCustomerDetails(Long id, Customer customer);
}
