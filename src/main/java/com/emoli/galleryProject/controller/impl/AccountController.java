package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.IAccountController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.DtoAccount;
import com.emoli.galleryProject.dto.DtoAccountIU;
import com.emoli.galleryProject.dto.DtoAddressIU;
import com.emoli.galleryProject.service.impl.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/account")
public class AccountController implements IAccountController {
	
	@Autowired
	private AccountService accountService;
	

	@PostMapping("/save")
	@Override
	public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
		return RootEntity.ok(accountService.saveAccount(dtoAccountIU));
		
	}

}


