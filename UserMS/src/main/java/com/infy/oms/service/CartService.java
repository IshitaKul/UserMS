package com.infy.oms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.oms.dto.CartDTO;
import com.infy.oms.entity.Cart;
import com.infy.oms.repository.CartRepository;


@Service
@Transactional
public class CartService {



	@Autowired
	CartRepository cartRepository;

	public List<CartDTO> getCartDetails() {
		List<Cart> cart = cartRepository.findAll();
		List<CartDTO> cartDTOs = new ArrayList<>();

		for (Cart c : cart) {
			CartDTO cartDTO = CartDTO.valueOf(c);
			cartDTOs.add(cartDTO);
		}


		return cartDTOs;
	}

	public String addToCart(CartDTO cartDTO) {
		
		Optional<Cart> optionalCart = cartRepository.findByBuyerIdAndProdId(cartDTO.getBuyerId(), cartDTO.getProdId());
		if (optionalCart.isPresent()) {
		
			return ("Already present in cart");
		} else {
			Cart cart = cartDTO.createEntity();
			cartRepository.save(cart);
			
			return "Added to cart";
		}
	}

	public String removeFromCart(Long buyerId, Long prodId) {
		
		Optional<Cart> optionalCart = cartRepository.findByBuyerIdAndProdId(buyerId, prodId);
		if (optionalCart.isPresent()) {
			cartRepository.deleteByBuyerIdAndProdId(buyerId, prodId);
			
			return "Removed from cart";
		} else {
		
			return "Product does not exist in cart";
		}

	}

	public CartDTO getSpecificDetails(Long buyerId, Long prodId) {
		// TODO Auto-generated method stub
		
		Optional<Cart> optionalCart = cartRepository.findByBuyerIdAndProdId(buyerId, prodId);
		if (optionalCart.isPresent()) {
			
			Cart cart = optionalCart.get();
			CartDTO cartDTO = CartDTO.valueOf(cart);
			return cartDTO;
		}
		return null;
	}
}
