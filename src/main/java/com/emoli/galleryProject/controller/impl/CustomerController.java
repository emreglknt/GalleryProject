package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.ICustomerController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.DtoCustomer;
import com.emoli.galleryProject.dto.DtoCustomerIU;
import com.emoli.galleryProject.service.impl.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerController extends RestBaseController implements ICustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoCustomer> saveAddress(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
		return ok(customerService.saveCustomer(dtoCustomerIU));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
