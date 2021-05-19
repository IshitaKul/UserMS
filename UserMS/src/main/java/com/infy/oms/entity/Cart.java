package com.infy.oms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
@IdClass(CartId.class)
public class Cart {
	
	@Id
	@Column(name = "BUYER_ID", unique = true, nullable = false, length = 11)
	Long buyerId;
	
	@Id
	@Column(name = "PROD_ID", unique = true, nullable = false, length = 11)
	Long prodId;
	
	@Column(name = "QUANTITY", unique = true, nullable = false, length = 11)
	Long quantity;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	
	
	
	

}
