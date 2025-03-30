package com.emoli.galleryProject.controller;

import java.util.List;

import com.emoli.galleryProject.dto.DtoCar;
import com.emoli.galleryProject.dto.DtoCarIU;

public interface ICarController {

	
	public RootEntity<DtoCar> saveCar (DtoCarIU dtoCarIU);
	
	
	public RootEntity<List<DtoCar>> getAllCars();
	
	
	public RootEntity<Void> deleteCarById(Long id);
	
	
}
