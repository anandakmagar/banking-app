package com.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{
	@Query(value = "select b from Beneficiary b where b.customerId=:customerId")
	public List<Beneficiary> findAllBeneficiariesByCustomerId(Long customerId);
}
