package com.expleo.salesmanDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.expleo.salesmanDetails.entity.Salesman;

@Controller
public class AdminController {
	 
	@Autowired
	RestTemplate restTemplate;
	
	private static final String BASE_URL = "http://localhost:8081";
	@GetMapping(path="login")
	public String login(@RequestParam String uname,@RequestParam String pswd) {
		if(uname.equals("Admin")) {
			if(pswd.equals("Admin"))
			{
		
			return "AdminDashboard";
		}
		}
		System.out.println(uname);
		System.out.println(pswd);
		return "index";
		
	}
	@GetMapping(path="addsales")
	public String addsales() {
		return "AddSalesman";
		
	}
	@GetMapping(path="salesmanData")
	public String salesmanData(Salesman s1,Model model) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL+"/addsalesmanData")
		        .queryParam("s1",s1);
		String url = builder.toUriString();
		
		ResponseEntity<ResponseModel> response = restTemplate.getForEntity(url, ResponseModel.class);
		ResponseModel result = response.getBody();
		String msg=result.message;
		model.addAttribute("msg", msg);
		return "AddSalesman";
		
	}
	
	
}
