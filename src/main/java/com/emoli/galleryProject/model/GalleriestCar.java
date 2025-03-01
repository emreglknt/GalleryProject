package com.emoli.galleryProject.model;

import java.math.BigDecimal;

import com.emoli.galleryProject.enums.CarStatusType;
import com.emoli.galleryProject.enums.CurrencyType;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
	    name = "galleriest_car",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = {"galleriest_id", "car_id"})
	    }
	)
@Data
@NoArgsConstructor
public class GalleriestCar  extends BaseEntity{

	
	@ManyToOne
	private Galleriest galleriest;
	
	
	@ManyToOne
	private Car car;
	
	
	
	
	
}
