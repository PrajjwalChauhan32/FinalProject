package com.project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Transaction;

@RepositoryRestResource(path="transaction")
@CrossOrigin("http://localhost:4200/")

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	public Page<Transaction> findByCustomerName(@RequestParam("customerName")String customerName,Pageable page);
	
	public Page<Transaction> findByPincode(@RequestParam("pincode")Integer pincode,Pageable page);
	
//	@Query("SELECT t FROM Transaction t WHERE t.totalAmount < 100")
//	List<Transaction> findAllTransactions();
	
	@Query("select t from Transaction t where t.totalAmount >(select u.upperLimit from FilterPreference u where u.merchantId = 1001)")
	List<Transaction> getTransactionsByUpperLimit();
	
	@Query("select t from Transaction t where t.totalAmount <(select u.upperLimit from FilterPreference u where u.merchantId = 1001)")
	List<Transaction> getTransactionsByLowerLimit();
	
	
}
