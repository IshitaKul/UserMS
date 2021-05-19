package com.infy.oms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.oms.entity.Wishlist;



public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

	Optional<Wishlist> findByBuyerIdAndProdId(Long buyerId, Long prodId);

	Optional<Wishlist> deleteByBuyerIdAndProdId(Long buyerId, Long prodId);

	List<Wishlist> findByBuyerId(Long buyerId);

	

}
