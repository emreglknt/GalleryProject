package com.emoli.galleryProject.dto;

import java.util.Date;

import com.emoli.galleryProject.model.Account;
import com.emoli.galleryProject.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomerIU {
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	@NotNull
	private String tckn;
	
	@NotNull
	private Date birthOfDate;
	
	@NotNull
	private Long addressId;
	@NotNull
	private Long accountId;
	
	
}
