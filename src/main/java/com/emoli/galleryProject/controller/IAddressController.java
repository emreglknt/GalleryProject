package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoAddressIU;

public interface IAddressController {
	
	public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}

