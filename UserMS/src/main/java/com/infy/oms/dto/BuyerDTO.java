package com.infy.oms.dto;

import com.infy.oms.entity.Buyer;

public class BuyerDTO {
	
	Long buyerId;
	
	String name;
	
	String email;
	
	String phoneNumber;
	
	String password;
	
	Integer isPrivileged;
	
	Long rewardPoints;
	
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

	
	public Integer getIsPrivileged() {
		return isPrivileged;
	}

	public void setIsPrivileged(Integer isPrivileged) {
		this.isPrivileged = isPrivileged;
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

	public BuyerDTO() {

	}

	public BuyerDTO(Long buyerId, String name, String email, String phoneNumber, String password,
			Integer isPrivileged, Long rewardPoints, Integer isActive) {
		this.buyerId = buyerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isPrivileged = isPrivileged;
		this.rewardPoints = rewardPoints;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "BuyerDTO [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", isPrivileged=" + isPrivileged + ", rewardPoints=" + rewardPoints
				+ ", isActive=" + isActive + "]";
	}
	
	
	//converts Entity to DTO
	public static BuyerDTO valueOf(Buyer buyer) {
		BuyerDTO buyerDTO = new BuyerDTO();
		
		buyerDTO.setBuyerId(buyer.getBuyerId());
		buyerDTO.setName(buyer.getName());
		buyerDTO.setEmail(buyer.getEmail());
		buyerDTO.setPhoneNumber(buyer.getPhoneNumber());
		buyerDTO.setPassword(buyer.getPassword());
		buyerDTO.setIsPrivileged(buyer.getIsprivileged());
		buyerDTO.setRewardPoints(buyer.getRewardPoints());
		buyerDTO.setIsActive(buyer.getIsActive());
		
		return buyerDTO;
	}
	
	
	//converts DTO to Entity
	public Buyer createEntity() {
		Buyer buyer = new Buyer();
		
		buyer.setBuyerId(this.getBuyerId());
		buyer.setName(this.getName());
		buyer.setEmail(this.getEmail());
		buyer.setPhoneNumber(this.getPhoneNumber());
		buyer.setPassword(this.getPassword());
		buyer.setIsprivileged(this.getIsPrivileged());
		buyer.setRewardPoints(this.getRewardPoints());
		buyer.setIsActive(this.getIsActive());
		return buyer;
	}

}
