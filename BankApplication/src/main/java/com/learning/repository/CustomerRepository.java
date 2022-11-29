package com.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Account;
import com.learning.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
//	@Query(value = "select a from account a where a.customerid =: customerid")
//	public List<Account> findAccountsByCustomerId(Long customerid);
}
