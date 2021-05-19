package com.infy.oms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.oms.dto.LoginDTO;
import com.infy.oms.dto.SellerDTO;
import com.infy.oms.entity.Seller;
import com.infy.oms.repository.SellerRepository;
import com.infy.oms.validator.Validator;


@Service
@Transactional
public class SellerService {

	@Autowired
	SellerRepository sellerRepository;

	public String createSeller(SellerDTO sellerDTO) throws Exception {
		

		String message = Validator.validateSeller(sellerDTO);
		if (message.equalsIgnoreCase("OK")) {
			Optional<Seller> optSellerPhone = sellerRepository.findByPhoneNo(sellerDTO.getPhoneNumber());
			Optional<Seller> optSellerEmail = sellerRepository.findByEmail(sellerDTO.getEmail());
			if (optSellerPhone.isPresent()) {
					return ("A seller with same phone number already exists! ");
			}
			if (optSellerEmail.isPresent()) {
				return ("A seller with same emailId already exists! ");
			}
			Seller seller = sellerDTO.createEntity();
			sellerRepository.save(seller);
			return ("OK");
			
		}
		return message;
	}

	public String login(LoginDTO loginDTO) {
		

		Optional<Seller> optSeller = sellerRepository.findByEmail(loginDTO.getEmail());
		if (optSeller.isPresent()) {
			Seller seller = optSeller.get();
			if (seller.getPassword().equals(loginDTO.getPassword())) {
				SellerDTO sellerDTO = SellerDTO.valueOf(seller);
				sellerDTO.setIsActive(1);
				Seller activatedSeller = sellerDTO.createEntity();
				sellerRepository.save(activatedSeller);
				return "Login successful";
			}
			return "Wrong email/password";
		}
		return "Account not registered. Register first";
	}

	public List<SellerDTO> sellerListAll() {
		

		List<SellerDTO> sellerDTOList = new ArrayList<>();
		List<Seller> sellerList = sellerRepository.findAll();
		for (Seller seller : sellerList) {
			SellerDTO sellerDTO = SellerDTO.valueOf(seller);
			sellerDTOList.add(sellerDTO);

		}
		return sellerDTOList;

	}

	public Long inactivateSeller(String email) {
		

		Optional<Seller> optSeller = sellerRepository.findByEmail(email);
		if (optSeller.isPresent()) {
			Seller seller = optSeller.get();
			SellerDTO sellerDTO = SellerDTO.valueOf(seller);
			sellerDTO.setIsActive(0);
			Seller activatedSeller = sellerDTO.createEntity();
			Long sellerId = sellerDTO.getSellerId();
			sellerRepository.save(activatedSeller);
			
			return sellerId;
		}
		return -1L;
	}

}
