package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.DtoAccount;
import com.emoli.galleryProject.dto.DtoAccountIU;
import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoAddressIU;

public interface IAccountController {

	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);

	
}
