package com.infy.oms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.oms.dto.BuyerDTO;
import com.infy.oms.dto.LoginDTO;
import com.infy.oms.entity.Buyer;
import com.infy.oms.repository.BuyerRepository;
import com.infy.oms.validator.Validator;



@Service
@Transactional
public class BuyerService {

	@Autowired
	BuyerRepository buyerRepository;

	

	public String createBuyer(BuyerDTO buyerDTO) throws Exception {
		

		String message = Validator.validateBuyer(buyerDTO);
		if (message.equalsIgnoreCase("OK")) {
			Optional<Buyer> optBuyerPhone = buyerRepository.findByPhoneNumber(buyerDTO.getPhoneNumber());
			Optional<Buyer> optBuyerEmail = buyerRepository.findByEmail(buyerDTO.getEmail());
			if (optBuyerPhone.isPresent()) {
				return ("A buyer with same phone number already exists! ");
			}
			if (optBuyerEmail.isPresent()) {
				return ("A buyer with same emailId already exists! ");
			}
			Buyer buyer = buyerDTO.createEntity();
			buyerRepository.save(buyer);
			return ("OK");
		}
		return message;
	}

	public String login(LoginDTO loginDTO) {
		

		Optional<Buyer> optBuyer = buyerRepository.findByEmail(loginDTO.getEmail());
		if (optBuyer.isPresent()) {
			Buyer buyer = optBuyer.get();
			if (buyer.getPassword().equals(loginDTO.getPassword())) {
				BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
				buyerDTO.setIsActive(1);
				Buyer activatedBuyer = buyerDTO.createEntity();
				buyerRepository.save(activatedBuyer);
				return "Login successful";
			}
			return "Wrong email/password";
		}
		return "Your are not registered. Register first";
	}

	public List<BuyerDTO> buyerListAll() {
		

		List<BuyerDTO> buyerDTOList = new ArrayList<>();
		List<Buyer> buyerList = buyerRepository.findAll();
		for (Buyer buyer : buyerList) {
			BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
			buyerDTOList.add(buyerDTO);

		}
		return buyerDTOList;

	}

	public String inactivateBuyer(String email) {
		

		Optional<Buyer> optBuyer = buyerRepository.findByEmail(email);
		if (optBuyer.isPresent()) {
			Buyer buyer = optBuyer.get();
			BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
			buyerDTO.setIsActive(0);
			Buyer activatedBuyer = buyerDTO.createEntity();
			buyerRepository.save(activatedBuyer);
			return "Account deactivated";
		}
		return "Account does not exist";
	}
	
	public BuyerDTO getSpecificBuyer(Long buyerId) {
		Optional<Buyer> optBuyer = buyerRepository.findById(buyerId);
		if (optBuyer.isPresent()) {
			Buyer buyer = optBuyer.get();
			BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
			return buyerDTO;
		}
		return null;
	}

	public String becomePrivilegedBuyer(Long buyerId) {
		// TODO Auto-generated method stub
		Optional<Buyer> optBuyer = buyerRepository.findById(buyerId);
		if (optBuyer.isPresent()) {
			Buyer buyer = optBuyer.get();
			BuyerDTO buyerDTO = BuyerDTO.valueOf(buyer);
			Long rewardPoints = buyerDTO.getRewardPoints();
			if (rewardPoints==null || rewardPoints<1000)
				return "You do not have enough reward points to become privileged buyer";
			else if (buyerDTO.getIsPrivileged()!=null && buyerDTO.getIsPrivileged()==1)
				return "You're already a privileged customer";
			else {
				buyerDTO.setIsPrivileged(1);
				Buyer newBuyer = buyerDTO.createEntity();
				buyerRepository.save(newBuyer);
				return "You're now a privileged Buyer";
			}
			
		}
		return "Buyer does not exist";
	}

}
