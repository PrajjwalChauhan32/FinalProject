package com.project.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Merchant")
public class Merchant implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="merchantid")
	private int merchantId;
	
	@Column (name="merchantname")
	private String merchantName;
	
	@Column (name="username")
	private String userName;
	
	@Column (name="password")
	private String password;
	
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "mechant") private Transaction transaction;
	 */
	 

	public Merchant() {

	}

	public Merchant(int merchantId, String merchantName, String userName, String password) {
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.userName = userName;
		this.password = password;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
