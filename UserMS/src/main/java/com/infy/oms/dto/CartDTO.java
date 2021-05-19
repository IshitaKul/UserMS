package com.infy.oms.dto;

import com.infy.oms.entity.Cart;

public class CartDTO {

	Long buyerId;

	Long prodId;

	Long quantity;

	@Override
	public String toString() {
		return "CartDTO [buyerId=" + buyerId + ", prodId=" + prodId + ", quantity=" + quantity + "]";
	}

	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(Long buyerId, Long prodId, Long quantity) {
		this.buyerId = buyerId;
		this.prodId = prodId;
		this.quantity = quantity;
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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	// Converts Entity to DTO
	public static CartDTO valueOf(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setQuantity(cart.getQuantity());
		cartDTO.setBuyerId(cart.getBuyerId());
		cartDTO.setProdId(cart.getProdId());
		return cartDTO;
	}

	// Converts DTO to Entity
	public Cart createEntity() {
		Cart cart = new Cart();
		cart.setBuyerId(this.getBuyerId());
		cart.setProdId(this.getProdId());
		cart.setQuantity(this.getQuantity());
		return cart;
	}

}
