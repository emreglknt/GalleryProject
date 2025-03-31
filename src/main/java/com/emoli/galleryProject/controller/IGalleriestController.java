package com.emoli.galleryProject.controller;

import java.util.List;

import com.emoli.galleryProject.dto.DtoCustomer;
import com.emoli.galleryProject.dto.DtoCustomerIU;
import com.emoli.galleryProject.dto.DtoGalleriest;
import com.emoli.galleryProject.dto.DtoGalleriestIU;

public interface IGalleriestController {

	public RootEntity<DtoGalleriest> saveGalleriest(DtoGalleriestIU dtoGalleriestIU);
	
	
	public RootEntity<List<DtoGalleriest>> getAllGalleriests();
	
	
	
	
}
