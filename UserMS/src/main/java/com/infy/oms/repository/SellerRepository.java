package com.infy.oms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.oms.entity.Seller;


public interface SellerRepository extends JpaRepository<Seller, Long> {

	Optional<Seller> findByEmail(String email);

	Optional<Seller> findByPhoneNo(String phoneNumber);

}
