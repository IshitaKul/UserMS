package com.infy.oms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.oms.dto.WishlistDTO;
import com.infy.oms.entity.Wishlist;
import com.infy.oms.repository.WishlistRepository;


@Service
@Transactional
public class WishlistService {
	

	@Autowired
	WishlistRepository wishlistRepository;

	public List<WishlistDTO> getWishlistDetails() {
		List<Wishlist> wishlist = wishlistRepository.findAll();
		List<WishlistDTO> wishlistDTOs = new ArrayList<>();

		for (Wishlist w : wishlist) {
			WishlistDTO wishlistDTO = WishlistDTO.valueOf(w);
			wishlistDTOs.add(wishlistDTO);
		}
	
		return wishlistDTOs;
	}

	public String addToWishlist(WishlistDTO wishlistDTO) {
		
		Optional<Wishlist> optionalWishlist = wishlistRepository.findByBuyerIdAndProdId(wishlistDTO.getBuyerId(),
				wishlistDTO.getProdId());
		if (optionalWishlist.isPresent()) {
			return "Product already present in wishlist";
		} else {
			Wishlist wishlist = wishlistDTO.createEntity();
			wishlistRepository.save(wishlist);
		
			return "Product added to wishlist";
		}
	}

	public String removeFromWishlist(Long buyerId, Long prodId) {
	
		Optional<Wishlist> optionalWishlist = wishlistRepository.findByBuyerIdAndProdId(buyerId, prodId);
		if (optionalWishlist.isPresent()) {
			wishlistRepository.deleteByBuyerIdAndProdId(buyerId, prodId);
		
			return "Product removed from wishlist";
		} else {
		
			return "Product does not exist in wishlist";
		}
	}

	public List<WishlistDTO> viewWishlist(Long buyerId) {
		List<Wishlist> wishLists = wishlistRepository.findByBuyerId(buyerId);
		List<WishlistDTO> wishlistDTOs = new ArrayList<>();
		for (Wishlist w : wishLists) {
			WishlistDTO wishlistDTO = WishlistDTO.valueOf(w);
			wishlistDTOs.add(wishlistDTO);
		}
	
		return wishlistDTOs;
	}

	public WishlistDTO getSpecificProductFromWishlist(Long buyerId, Long prodId) {
		Optional<Wishlist> optionalWishlist = wishlistRepository.findByBuyerIdAndProdId(buyerId, prodId);
		if (optionalWishlist.isPresent()) {
			Wishlist wishlist = optionalWishlist.get();
			WishlistDTO wishlistDTO = WishlistDTO.valueOf(wishlist);
			return wishlistDTO;
		}
		return null;
	}

}
