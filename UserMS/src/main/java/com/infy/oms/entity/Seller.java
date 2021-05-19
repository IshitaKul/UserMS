package com.infy.oms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seller")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SELLER_ID", unique = true, nullable = false, length = 11)
	Long sellerId;
	
	@Column(name ="NAME", length = 45, nullable = false)
	String name;
	
	@Column(name ="EMAIL", length = 45, nullable = false)
	String email;
	
	@Column(name ="PHONE_NUMBER", length = 45, nullable = false)
	String phoneNo;
	
	@Column(name ="PASSWORD", length = 45, nullable = false)
	String password;
	
	@Column(name = "IS_ACTIVE", length = 1)
	Integer isActive;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	

}
