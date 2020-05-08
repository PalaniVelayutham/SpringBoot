package com.customProduct.customProduct.admin;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customProduct.customProduct.exception.ResourceNotFoundException;
import com.customProduct.customProduct.model.ResponseTemplate;

@RestController
@RequestMapping("/api/")
public class Controller {

	@GetMapping("getproductdetails")
	public ResponseTemplate getproductdetails() throws ResourceNotFoundException {
		ResponseTemplate res =new ResponseTemplate(new Date(),"getproductdetails","productName");
		return res;
	}
	
	@GetMapping("getconfigdetails")
	public ResponseTemplate getconfigdetails() throws ResourceNotFoundException {
		ResponseTemplate res =new ResponseTemplate(new Date(),"getconfigdetails","getconfigdetails");
		return res;
	}
	

}
