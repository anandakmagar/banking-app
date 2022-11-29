package com.learning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.entity.Beneficiary;

@Service
public interface BeneficiaryService {
	public Beneficiary addBeneficiary(Long customerId, Beneficiary beneficiary);
	public List<Beneficiary> findAllBeneficiariesByCustomerId(Long customerId);
	public void deleteBeneficiaryByBeneficiaryId(Long customerId, Long beneficiaryId);

}
