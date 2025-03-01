package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoAddressIU;
import com.emoli.galleryProject.dto.DtoCustomer;
import com.emoli.galleryProject.dto.DtoCustomerIU;

public interface ICustomerController {

	public RootEntity<DtoCustomer> saveAddress(DtoCustomerIU dtoCustomerIU);
}
