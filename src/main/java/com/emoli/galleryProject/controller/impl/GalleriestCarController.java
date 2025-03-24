package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.IGalleriestCarController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.DtoGalleriestCar;
import com.emoli.galleryProject.dto.DtoGalleriestCarIU;
import com.emoli.galleryProject.service.impl.GalleriestCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/galleriest-car")
public class GalleriestCarController extends RestBaseController implements IGalleriestCarController {

	@Autowired
	private GalleriestCarService galleriestCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoGalleriestCar> saveGalleriestCar(@RequestBody DtoGalleriestCarIU dtoGalleriestCarIU) {
		
		return ok(galleriestCarService.saveGalleriestCar(dtoGalleriestCarIU));
	}

}



