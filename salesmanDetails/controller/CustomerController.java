package com.expleo.salesmanDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.expleo.salesmanDetails.entity.customers;
 

@Controller
public class CustomerController {
	
	@Autowired
	RestTemplate restTemplate;
	private String BASE_URL = "http://localhost:8081";
	 
	@GetMapping(path="addCus")
	public String addCus() {
		return "AddCustomer";
		
	}
	@GetMapping(path="SaveCus")
	public String SaveCus(customers c1) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL+"/SaveCusData")
		        .queryParam("c1",c1);
		String url = builder.toUriString();
		
		ResponseEntity<ResponseModel> response = restTemplate.getForEntity(url, ResponseModel.class);
		ResponseModel result = response.getBody();
		String msg=result.message;
		
		return "CustomerData";
		
	}
}
