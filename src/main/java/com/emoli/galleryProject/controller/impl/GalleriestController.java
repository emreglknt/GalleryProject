package com.emoli.galleryProject.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.IGalleriestController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.DtoGalleriest;
import com.emoli.galleryProject.dto.DtoGalleriestIU;
import com.emoli.galleryProject.service.impl.GalleriestService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/rest/api/galleriest")
public class GalleriestController extends RestBaseController implements IGalleriestController {

	
	@Autowired
	private GalleriestService galleriestService;
	
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoGalleriest> saveGalleriest(@Valid @RequestBody	DtoGalleriestIU dtoGalleriestIU) {
		
		return ok(galleriestService.saveGalleriest(dtoGalleriestIU));

	}

	

	@GetMapping("/list-all")
	@Override
	public RootEntity<List<DtoGalleriest>> getAllGalleriests() {
		
		List<DtoGalleriest> dtoGalleriestsList = galleriestService.getAllGalleriests();
		
		return ok(dtoGalleriestsList);
	
	}

	
	 
	
	
}
