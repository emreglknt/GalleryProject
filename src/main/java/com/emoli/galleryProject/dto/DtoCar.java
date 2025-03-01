package com.emoli.galleryProject.dto;

import java.math.BigDecimal;

import com.emoli.galleryProject.enums.CarStatusType;
import com.emoli.galleryProject.enums.CurrencyType;

import lombok.Data;

@Data
public class DtoCar extends DtoBase{

	  
    private String plaka;

   
    private String brand;

   
    private String model;

   
    private Integer prductionYear;


    private BigDecimal price;
    
    
    private  CurrencyType currencyType;
    

    private BigDecimal damagePrice;
    

    private CarStatusType carStatusType;
	
	
	
}
