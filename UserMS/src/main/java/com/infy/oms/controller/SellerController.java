package com.infy.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.oms.dto.LoginDTO;
import com.infy.oms.dto.SellerDTO;
import com.infy.oms.service.SellerService;


@RestController
public class SellerController {

	@Autowired
	SellerService sellerService;
//
//	@Value("${product.uri}")
//	String productUri;

	@PostMapping(value = "/seller/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createSeller(@RequestBody SellerDTO sellerDTO) throws Exception {
		
		String message = sellerService.createSeller(sellerDTO);
		if (message.equalsIgnoreCase("ok")) {
			return new ResponseEntity<String>("You are registered succesfully!!!", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@PostMapping(value = "/seller/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) throws Exception {
		
		String message = sellerService.login(loginDTO);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping(value = "/seller/sellers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SellerDTO> getAllSellers() {
		
		return sellerService.sellerListAll();
	}

	@DeleteMapping(value = "/seller/deactivate")
	public ResponseEntity<String> inactivateSeller(@RequestBody SellerDTO sellerDTO) {
		
		RestTemplate restTemplate = new RestTemplate();
		Long sellerId = sellerService.inactivateSeller(sellerDTO.getEmail());
		
		if (sellerId != -1L) {
			
			restTemplate.delete("http://localhost:8100/products" + "/seller/" + sellerId);
			return new ResponseEntity<>("Account deleted succesfully!!!", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Account does not exist!!!", HttpStatus.BAD_REQUEST);
	}
}
