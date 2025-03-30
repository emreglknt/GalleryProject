package com.emoli.galleryProject.service;

import com.emoli.galleryProject.dto.DtoSaledCar;
import com.emoli.galleryProject.dto.DtoSaledCarIU;

public interface ISaledCarService {

	
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);
	
	
}
