package com.infy.oms.dto;

import java.util.List;

import com.infy.oms.entity.Wishlist;

public class WishlistDTO {

	Long buyerId;
	Long prodId;
	String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public WishlistDTO() {
		// TODO Auto-generated constructor stub
	}

	public WishlistDTO(Long buyerId, Long prodId) {
		this.buyerId = buyerId;
		this.prodId = prodId;
	}

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

	@Override
	public String toString() {
		return "WishlistDTO [buyerId=" + buyerId + ", prodId=" + prodId + "]";
	}

	// Converts Entity to DTO
	public static WishlistDTO valueOf(Wishlist wishlist) {
		WishlistDTO wishlistDTO = new WishlistDTO();
		wishlistDTO.setBuyerId(wishlist.getBuyerId());
		wishlistDTO.setProdId(wishlist.getProdId());
		return wishlistDTO;
	}

	// Converts DTO to Entity
	public Wishlist createEntity() {
		Wishlist wishlist = new Wishlist();
		wishlist.setBuyerId(this.getBuyerId());
		wishlist.setProdId(this.getProdId());
		return wishlist;
	}

}
