package com.learning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import com.learning.entity.Customer;
import com.learning.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long id) {
		return customerService.findCustomerById(id);
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomerDetails(@PathVariable("id") Long id, @RequestBody Customer customer) {
		return customerService.updateCustomerDetails(id, customer);
	}
}
