package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.DtoGalleriestCar;
import com.emoli.galleryProject.dto.DtoGalleriestCarIU;

public interface IGalleriestCarController {

	public RootEntity<DtoGalleriestCar> saveGalleriestCar(DtoGalleriestCarIU dtoGalleriestCarIU);
	
	
}
