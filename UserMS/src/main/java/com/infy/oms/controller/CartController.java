package com.infy.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.oms.dto.CartDTO;
import com.infy.oms.dto.WishlistDTO;
import com.infy.oms.service.CartService;
import com.infy.oms.service.WishlistService;

@RestController
public class CartController {



	@Autowired
	CartService cartService;
	
	@Autowired
	WishlistService wishlistService;
	
	@GetMapping(value = "/cart",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CartDTO> getCartDetails(){

		return cartService.getCartDetails();
	}
	
	@PostMapping(value = "/cart/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO) {
	
		String message = cartService.addToCart(cartDTO);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/cart/remove/{buyerId}/{prodId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeFromCart(@PathVariable Long buyerId, @PathVariable Long prodId) {
	
		String message = cartService.removeFromCart(buyerId, prodId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}	
	
	@PostMapping(value = "/cart/addFromWishlist")
	public ResponseEntity<String> addToCartFromWishlist(@RequestBody CartDTO cartDTO) {
	
	WishlistDTO wishlistDTO = wishlistService.getSpecificProductFromWishlist(cartDTO.getBuyerId(), cartDTO.getProdId());
	if (wishlistDTO == null)
		return new ResponseEntity<>("No such product in Wishlist", HttpStatus.OK);
	String message = cartService.addToCart(cartDTO);
	return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	

	@GetMapping(value = "/cart/{buyerId}/{prodId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public CartDTO getSpecificDetails(@PathVariable Long buyerId, @PathVariable Long prodId){
	
		return cartService.getSpecificDetails(buyerId, prodId);
	}
}
