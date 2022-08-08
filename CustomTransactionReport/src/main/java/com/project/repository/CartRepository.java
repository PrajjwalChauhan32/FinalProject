package com.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Cart;
import com.project.entity.Transaction;


@RepositoryRestResource(path="cart")
@CrossOrigin("http://localhost:4200/")
public interface CartRepository extends JpaRepository<Cart, Integer>{
	public Page<Cart> findByCartId(@RequestParam("cartId")Integer cartId,Pageable page);

}
