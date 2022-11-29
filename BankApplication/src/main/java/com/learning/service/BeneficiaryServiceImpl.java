package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
import com.learning.repository.AccountRepository;
import com.learning.repository.BeneficiaryRepository;
import com.learning.repository.CustomerRepository;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	
	public Beneficiary addBeneficiary(Long customerId, Beneficiary beneficiary) {
		if(customerRepository.existsById(customerId)) {
			beneficiary.setCustomerId(customerId);
			beneficiaryRepository.save(beneficiary);
		}
		return beneficiary;
		
	}

	@Override
	public List<Beneficiary> findAllBeneficiariesByCustomerId(Long customerId) {
		var beneficiaries = (List<Beneficiary>) beneficiaryRepository.findAllBeneficiariesByCustomerId(customerId);
		return beneficiaries;
	}

	@Override
	public void deleteBeneficiaryByBeneficiaryId(Long customerId, Long beneficiaryId) {
		if(customerRepository.existsById(customerId)) {
			beneficiaryRepository.deleteById(beneficiaryId);
		}
		
	}
}