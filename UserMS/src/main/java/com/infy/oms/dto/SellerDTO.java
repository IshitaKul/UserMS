package com.infy.oms.dto;

import com.infy.oms.entity.Seller;

public class SellerDTO {

	Long sellerId;

	String name;

	String email;

	String phoneNumber;

	String password;

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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public SellerDTO() {

	}

	public SellerDTO(Long sellerId, String name, String email, String phoneNumber, String password, Integer isActive) {
		this.sellerId = sellerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "SellerDTO [sellerId=" + sellerId + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", isActive=" + isActive + "]";
	}

	public Seller createEntity() {
		Seller seller = new Seller();
		seller.setSellerId(this.getSellerId());
		seller.setEmail(this.getEmail());
		seller.setIsActive(this.getIsActive());
		seller.setName(this.getName());
		seller.setPassword(this.getPassword());
		seller.setPhoneNo(this.getPhoneNumber());
		return seller;
	}

	public static SellerDTO valueOf(Seller seller) {
		SellerDTO sellerDTO = new SellerDTO();
		sellerDTO.setSellerId(seller.getSellerId());
		sellerDTO.setEmail(seller.getEmail());
		sellerDTO.setIsActive(seller.getIsActive());
		sellerDTO.setName(seller.getName());
		sellerDTO.setPassword(seller.getPassword());
		sellerDTO.setPhoneNumber(seller.getPhoneNo());
		return sellerDTO;
	}

}
