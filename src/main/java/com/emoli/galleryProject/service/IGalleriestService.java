package com.emoli.galleryProject.service;

import java.util.List;

import com.emoli.galleryProject.dto.DtoGalleriest;
import com.emoli.galleryProject.dto.DtoGalleriestIU;

public interface IGalleriestService {

	public DtoGalleriest saveGalleriest(DtoGalleriestIU dtoGalleriestIU);
	
	public List<DtoGalleriest> getAllGalleriests();
	
	
}
