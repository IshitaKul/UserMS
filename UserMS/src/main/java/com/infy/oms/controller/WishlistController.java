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
import org.springframework.web.client.RestTemplate;


import com.infy.oms.dto.WishlistDTO;
import com.infy.oms.service.WishlistService;


@RestController
public class WishlistController {

	@Autowired
	RestTemplate template;

	@Autowired
	WishlistService wishlistService;
	
	@GetMapping(value = "/wishlist/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WishlistDTO> viewWishlist(@PathVariable Long buyerId){

		return wishlistService.viewWishlist(buyerId);
	}
	
	@GetMapping(value = "/wishlist",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WishlistDTO> getWishlistDetails(){

		return wishlistService.getWishlistDetails();
	}
	
	@PostMapping(value = "/wishlist",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addToWishlist(@RequestBody WishlistDTO wishlistDTO) {

		String message = wishlistService.addToWishlist(wishlistDTO);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/wishlist/{buyerId}/{prodId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeFromWishlist(@PathVariable Long buyerId, @PathVariable Long prodId) {
	
		String message = wishlistService.removeFromWishlist(buyerId, prodId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping(value = "/wishlist/{buyerId}/{prodId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public WishlistDTO getSpecificProductFromWishlist(@PathVariable Long buyerId, @PathVariable Long prodId) {
//		RestTemplate template = new RestTemplate();
//		String productName= template.getForObject("http://localhost:8100/products/"+prodId, String.class);
//		String productName= template.getForObject("http://PRODUCTMS"+"/products/"+prodId, String.class);
		String productName= template.getForObject("http://PRODUCTMS"+"/products/"+prodId, String.class);
		WishlistDTO wDto= wishlistService.getSpecificProductFromWishlist(buyerId, prodId);
		wDto.setProductName(productName);
		return wDto;
	}
	
}
