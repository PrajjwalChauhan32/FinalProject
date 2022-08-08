package com.project.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Transaction")
public class Transaction implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="transactionid")
	private int transactionId;
	
	@Column (name="merchantid")
	private int merchantId;
	
	@Column (name="customername")
	private String customerName;
	
	@Column (name="cartid")
	private int cartId;
	

	@Column (name="purchasedat")
	private Date purchasedAt;
	
	@Column (name="billingaddress")
	private String billingAddress;
	
	@Column(name="totalamount")
	private float totalAmount;
	
	@Column (name="paymentreceived")
	private Date paymentReceived;
	
	@Column (name="pincode")
	private int pincode;

//	@OneToOne
//	@JoinColumn(name="cartid")
//	private Cart cart;


//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	
	
	  @OneToOne(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name = "merchantid", nullable = false, unique = true,
	  insertable=false, updatable=false) private Merchant merchant;
	  
	  
	  
	  @OneToOne(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name = "cartid", nullable = false, unique = true,
	  insertable=false, updatable=false) private Cart cart;
	 
	
	
	

	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}



	public Transaction() {
		
	}



	public Transaction(int transactionId, int merchantId, String customerName, int cartId, Date purchasedAt,
			String billingAddress, float totalAmount, Date paymentReceived, int pincode, Merchant merchant) {
		this.transactionId = transactionId;
		this.merchantId = merchantId;
		this.customerName = customerName;
		this.cartId = cartId;
		this.purchasedAt = purchasedAt;
		this.billingAddress = billingAddress;
		this.totalAmount = totalAmount;
		this.paymentReceived = paymentReceived;
		this.pincode = pincode;
		this.merchant = merchant;
	}



	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}



	public int getMerchantId() {
		return merchantId;
	}



	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public Date getPurchasedAt() {
		return purchasedAt;
	}



	public void setPurchasedAt(Date purchasedAt) {
		this.purchasedAt = purchasedAt;
	}



	public String getBillingAddress() {
		return billingAddress;
	}



	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}



	public float getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}



	public Date getPaymentReceived() {
		return paymentReceived;
	}



	public void setPaymentReceived(Date paymentReceived) {
		this.paymentReceived = paymentReceived;
	}



	public int getPincode() {
		return pincode;
	}



	public void setPincode(int pincode) {
		this.pincode = pincode;
	}



	public Merchant getMerchant() {
		return merchant;
	}



	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
	
	
}
