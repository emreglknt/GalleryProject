package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.DtoSaledCar;
import com.emoli.galleryProject.dto.DtoSaledCarIU;

public interface ISaledCarController {

	
	public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU); 
	
	
}
