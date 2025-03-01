package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.DtoCar;
import com.emoli.galleryProject.dto.DtoCarIU;

public interface ICarController {

	
	public RootEntity<DtoCar> saveCar (DtoCarIU dtoCarIU);
	
}
