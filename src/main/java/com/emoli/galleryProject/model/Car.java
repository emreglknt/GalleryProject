package com.emoli.galleryProject.model;

import java.math.BigDecimal;
import java.util.Date;

import com.emoli.galleryProject.enums.CarStatusType;
import com.emoli.galleryProject.enums.CurrencyType;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
public class Car extends BaseEntity {
	

	    @Column(name = "plaka")
	    private String plaka;
	
	    @Column(name = "brand")
	    private String brand;

	    @Column(name = "model")
	    private String model;

	    @Column(name = "production_year")
	    private Integer prductionYear;

	    @Column(name = "price")
	    private BigDecimal price;
	    
	    
	    @Column(name = "currency")
	    private  CurrencyType currencyType;
	    
	    @Column(name = "damage_price")
	    private BigDecimal damagePrice;
	    
	
	    @Column(name = "car_status")
	    @Enumerated(EnumType.STRING)
	    private CarStatusType carStatusType;
	    
	    
	
}
