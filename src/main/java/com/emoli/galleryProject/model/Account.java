package com.emoli.galleryProject.model;

import java.math.BigDecimal;

import com.emoli.galleryProject.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity{

	@Column(name = "account_no")
	private String accountNo;
	
	@Column(name = "iban")
	private String ibanNo;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "currency_type")
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	
	
}
