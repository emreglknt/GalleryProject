package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.ISaledCarController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.DtoSaledCar;
import com.emoli.galleryProject.dto.DtoSaledCarIU;
import com.emoli.galleryProject.service.ISaledCarService;
import com.emoli.galleryProject.service.impl.SaledCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/saled-car")
public class SaledCarController extends RestBaseController  implements ISaledCarController{

	
	@Autowired
	private SaledCarService saledCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
		
		return ok(saledCarService.buyCar(dtoSaledCarIU));
	}

}
