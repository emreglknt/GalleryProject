package com.emoli.galleryProject.service;

import com.emoli.galleryProject.dto.DtoCustomer;
import com.emoli.galleryProject.dto.DtoCustomerIU;

public interface ICustomerService {

	
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
	
	
}
