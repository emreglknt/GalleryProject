package com.emoli.galleryProject.service;

import java.util.List;


import com.emoli.galleryProject.dto.DtoCar;
import com.emoli.galleryProject.dto.DtoCarIU;

public interface ICarService {

	
	public DtoCar saveCar (DtoCarIU dtoCarIU);
	

	public List<DtoCar> getAllCars();
	
	
	public void deleteCarById(Long id);
	
	
	
}
