package com.emoli.galleryProject.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoAddressIU;
import com.emoli.galleryProject.model.Address;
import com.emoli.galleryProject.repo.AddressRepository;
import com.emoli.galleryProject.service.IAdressService;

@Service
public class AddressService implements IAdressService {

	
	@Autowired
	private AddressRepository addressRepository;
	
	
	private Address createAddress(DtoAddressIU dtoAddressIU) {
		Address address = new Address();
		address.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoAddressIU, address);
		return address;
	}
	
	
	
	@Override
	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {

		DtoAddress dtoAddress = new DtoAddress();
		Address savedAddress = 	addressRepository.save(createAddress(dtoAddressIU));
		
		BeanUtils.copyProperties(savedAddress,dtoAddress);
		
		return dtoAddress;
		
	}

}
