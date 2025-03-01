package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.IAddressController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoAddressIU;
import com.emoli.galleryProject.service.impl.AddressService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/rest/api/address")
public class AddressController extends RestBaseController implements IAddressController{

	
	@Autowired
	private AddressService addressService;
	
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
		
		return ok(addressService.saveAddress(dtoAddressIU));	
	}

	
	
	
}
