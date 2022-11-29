package com.learning.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.entity.Customer;
import com.learning.repository.AccountRepository;
import com.learning.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer findCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}
	
	@Override
	public Customer updateCustomerDetails(Long id, Customer customer) {
        Customer customer1 = customerRepository.findById(id).get();

        if(Objects.nonNull(customer.getId())) {
        	customer1.setId(customer.getId());
        }
        
        if(Objects.nonNull(customer.getEmail())) {
        	customer1.setEmail(customer.getEmail());
        }
        
        if(Objects.nonNull(customer.getPhoneNumber())) {
        	customer1.setPhoneNumber(customer.getPhoneNumber());
        }
        
        if(Objects.nonNull(customer.getAddress())) {
        	customer1.setAddress(customer.getAddress());
        }
        
        if(Objects.nonNull(customer.getFullName())) {
        	customer1.setFullName(customer.getFullName());
        }
        
        if(Objects.nonNull(customer.getUsername())) {
        	customer1.setUsername(customer.getUsername());
        }
        
        if(Objects.nonNull(customer.getPassword())) {
        	customer1.setPassword(customer.getPassword());
        }
        
        if(Objects.nonNull(customer.getStatus())) {
        	customer1.setStatus(customer.getStatus());
        }
        
        if(Objects.nonNull(customer.getSecurityQuestionAnswer())) {
        	customer1.setSecurityQuestionAnswer(customer.getSecurityQuestionAnswer());
        }
		return customerRepository.save(customer1);
	}
	
	
	
	
	
	
	
}
