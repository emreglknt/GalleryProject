package com.emoli.galleryProject.dto;

import java.math.BigDecimal;

import com.emoli.galleryProject.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DtoAccount extends DtoBase {
	
	
	private String accountNo;
	
	
	private String ibanNo;
	
	
	private BigDecimal amount;
	
	
	private CurrencyType currencyType;
	
	
}
