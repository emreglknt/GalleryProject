package com.emoli.galleryProject.dto;

import java.math.BigDecimal;

import com.emoli.galleryProject.enums.CurrencyType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoAccountIU {

	
	@NotNull
	private String accountNo;
	
	@NotNull
	private String ibanNo;
	
	@NotNull
	private BigDecimal amount;
	
	@NotNull
	private CurrencyType currencyType;
	
	
	
}
