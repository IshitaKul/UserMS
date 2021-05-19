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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.oms.dto.BuyerDTO;
import com.infy.oms.dto.LoginDTO;
import com.infy.oms.service.BuyerService;



@RestController
public class BuyerController {

	@Autowired
	BuyerService buyerService;

	@PostMapping(value = "/buyer/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createBuyer(@RequestBody BuyerDTO buyerDTO) throws Exception {
		
		String message = buyerService.createBuyer(buyerDTO);
		if (message.equalsIgnoreCase("ok")) {
			return new ResponseEntity<String>("You are registered succesfully!!!", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);

	}

	@PostMapping(value = "/buyer/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> Login(@RequestBody LoginDTO loginDTO) throws Exception {
		
		String message = buyerService.login(loginDTO);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping(value = "/buyer/buyers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerDTO> getAllBuyers() {
		
		return buyerService.buyerListAll();
	}

	@DeleteMapping(value = "/buyer/inactivate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> inactivateBuyer(@RequestBody BuyerDTO buyerDTO) {
		

		String message = buyerService.inactivateBuyer(buyerDTO.getEmail());
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buyer/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BuyerDTO getSpecificBuyer(@PathVariable Long buyerId) {
		return buyerService.getSpecificBuyer(buyerId);
	}
	
	@PutMapping(value = "/buyer/applyForPrivilege/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> becomePrivilegedBuyer(@PathVariable Long buyerId) {
		String message = buyerService.becomePrivilegedBuyer(buyerId);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
}
