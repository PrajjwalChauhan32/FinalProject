package com.project.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")

public class Cart implements Serializable {
	@Id
	@Column(name = "cartid")
	private int cartId;

	@Column(name = "productid")
	private int productId;

	@Column(name = "quantity")
	private int quantity;

//	@OneToMany(mappedBy = "productid")
//	private Set<Product> products ;
//	
//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}

	
	  @OneToMany(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name= "productid", nullable = false, unique = true,
	  insertable=false, updatable=false) private Set<Product> products;
	  
	  
	  public Set<Product> getProduct() { return products; }
	  
	  public void setProduct(Set<Product> products) { this.products = products; }
	 

	public Cart() {

	}

	public Cart(int cartId, int productId, int quantity,Set<Product> products) {
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.products = products;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
