package com.infy.oms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUYER_ID", unique = true, nullable = false, length = 11)
	Long buyerId;

	@Column(name = "NAME", length = 45, nullable = false)
	String name;

	@Column(name = "EMAIL", length = 45, nullable = false)
	String email;

	@Column(name = "PHONE_NUMBER", length = 45, nullable = false)
	String phoneNumber;

	@Column(name = "PASSWORD", length = 45, nullable = false)
	String password;

	@Column(name = "IS_PRIVILEGED", length = 1)
	Integer isprivileged;

	@Column(name = "REWARD_POINTS", length = 11)
	Long rewardPoints;

	@Column(name = "IS_ACTIVE", length = 1)
	Integer isActive;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsprivileged() {
		return isprivileged;
	}

	public void setIsprivileged(Integer isprivileged) {
		this.isprivileged = isprivileged;
	}

	public Long getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
