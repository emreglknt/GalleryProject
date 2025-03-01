package com.emoli.galleryProject.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emoli.galleryProject.dto.DtoAccount;
import com.emoli.galleryProject.dto.DtoAccountIU;
import com.emoli.galleryProject.dto.DtoAddressIU;
import com.emoli.galleryProject.model.Account;
import com.emoli.galleryProject.repo.AccountRepository;
import com.emoli.galleryProject.service.IAccountService;

@Service
public class AccountService implements IAccountService {

	
	@Autowired
	private AccountRepository accountRepository;
	
	private Account createAccount(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		account.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoAccountIU, account);
		
		return account;
		
		
	}
	
	
	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
	
		DtoAccount dtoAccount = new DtoAccount(); 
		
		Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));

		BeanUtils.copyProperties(savedAccount, dtoAccount);

		return dtoAccount;
	
	}

	
	
	
	
	
	
	
}
