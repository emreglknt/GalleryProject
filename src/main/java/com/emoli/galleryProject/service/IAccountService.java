package com.emoli.galleryProject.service;

import com.emoli.galleryProject.dto.DtoAccount;
import com.emoli.galleryProject.dto.DtoAccountIU;
import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoAddressIU;

public interface IAccountService {
	
	public DtoAccount saveAccount (DtoAccountIU dtoAccount);
	
}
