package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Beneficiary;
import com.learning.service.BeneficiaryService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BeneficiaryController {
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@PostMapping("/customer/{customerId}/beneficiary")
	public Beneficiary addBeneficiary(@PathVariable("customerId") Long customerId, @RequestBody Beneficiary beneficiary) {
		return beneficiaryService.addBeneficiary(customerId, beneficiary);
	}
	
	@GetMapping("/customer/{customerId}/beneficiary")
	public List<Beneficiary> findAllBeneficiariesByCustomerId(@PathVariable("customerId") Long customerId){
		return beneficiaryService.findAllBeneficiariesByCustomerId(customerId);
	}

	@DeleteMapping("/customer/{customerId}/beneficiary/{beneficiaryId}")
	public void deleteBeneficiaryByBeneficiaryId(@PathVariable("customerId") Long customerId, @PathVariable("beneficiaryId") Long beneficiaryId) {
		beneficiaryService.deleteBeneficiaryByBeneficiaryId(customerId, beneficiaryId);
	}
}
