package com.project.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
	

	
	@Query("select t from Transaction t where t.totalAmount >(select u.upperLimit from FilterPreference u where u.merchantId = 1001)")
	List<Transaction> getTransactionsByUpperLimit();
	
	@Query("select t from Transaction t where t.totalAmount <(select u.upperLimit from FilterPreference u where u.merchantId = 1001)")
	List<Transaction> getTransactionsByLowerLimit();
	
	public Page<Transaction> findByTotalAmountGreaterThan(@RequestParam("totalAmount")Float totalAmount,Pageable page);
	
	
	public Page<Transaction> findByTotalAmountLessThan(@RequestParam("totalAmount")Float totalAmount,Pageable page);
	

	@Query(value ="select * from Transaction t where t.purchasedAt > :t1 and t.purchasedAt < :t2 ;", nativeQuery=true)
	List<Transaction> findByPurchasedAt(@RequestParam("t1")Date t1,@RequestParam("t2")Date t2);
	
	//select * from Transaction where customername=(select customername from transaction group by customername having purchasedat > '2020-01-10 07:30:45' and purchasedat < '2022-01-10 07:30:45' order by count(customername) desc limit 1);
	@Query(value="select * from Transaction t where t.customername = (select customername from transaction group by customername having purchasedAt > :t1 and purchasedAt < :t2 order by count(customername) desc limit 1);", nativeQuery=true)
	List<Transaction> getTransactionsReportByCustomerVolume(@RequestParam("t1")Date t1,@RequestParam("t2")Date t2);
	
	@Query(value="select * from transaction where purchasedAt > :t1 and purchasedAt < :t2 order by totalamount desc limit 3;", nativeQuery=true)
	List<Transaction> getCustomerValueReport(@RequestParam("t1")Date t1,@RequestParam("t2")Date t2);
	
	
	
}
