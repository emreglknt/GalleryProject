package com.emoli.galleryProject.service.impl;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emoli.galleryProject.dto.DtoAccount;
import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoCustomer;
import com.emoli.galleryProject.dto.DtoCustomerIU;
import com.emoli.galleryProject.exception.BaseException;
import com.emoli.galleryProject.exception.ErrorMessage;
import com.emoli.galleryProject.exception.MessageType;
import com.emoli.galleryProject.model.Account;
import com.emoli.galleryProject.model.Address;
import com.emoli.galleryProject.model.Customer;
import com.emoli.galleryProject.repo.AccountRepository;
import com.emoli.galleryProject.repo.AddressRepository;
import com.emoli.galleryProject.repo.CustomerRepository;
import com.emoli.galleryProject.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	
	
	
	public Customer createCustomer(DtoCustomerIU dtoCustomerIU){
		Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
		if(optAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoCustomerIU.getAddressId().toString()));
		}
		
		Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
		if(optAccount.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
		}
		
		Customer customer = new Customer();
		customer.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		
		customer.setAddress(optAddress.get());
		customer.setAccount(optAccount.get());
		
		
		return customer;
		
		
		
	}
	
	
	
	
	
	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		DtoAccount dtoAccount = new DtoAccount(); 
		
		
		Customer savedCustomer = 	customerRepository.save(createCustomer(dtoCustomerIU));
		BeanUtils.copyProperties(savedCustomer,dtoCustomerIU);
		BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);
		
		dtoCustomer.setDtoAddress(dtoAddress);
		dtoCustomer.setDtoAccount(dtoAccount);
		
		return dtoCustomer;
		
	}
	
	
	
	

}
