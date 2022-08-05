package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filterpreference")
public class FilterPreference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="filterid")
	private int filterId;
	
	@Column (name="merchantid")
	private int merchantId;
	
	@Column (name="upperlimit")
	private float upperLimit;
	
	@Column (name="lowerlimit")
	private float lowerLimit;
	
	@Column (name="pincode")
	private int pincode;
	
	@Column (name="customername")
	private String customerName;

	public FilterPreference() {
	
	}

	public FilterPreference(int filterId, int merchantId, float upperLimit, float lowerLimit, int pincode,
			String customerName) {
		this.filterId = filterId;
		this.merchantId = merchantId;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.pincode = pincode;
		this.customerName = customerName;
	}

	public int getFilterId() {
		return filterId;
	}

	public void setFilterId(int filterId) {
		this.filterId = filterId;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public float getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(float upperLimit) {
		this.upperLimit = upperLimit;
	}

	public float getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(float lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
