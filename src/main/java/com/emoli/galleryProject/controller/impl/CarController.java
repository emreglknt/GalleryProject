package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.ICarController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.DtoCar;
import com.emoli.galleryProject.dto.DtoCarIU;
import com.emoli.galleryProject.service.impl.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/car")
public class CarController extends RestBaseController implements ICarController {

	@Autowired
	private CarService carService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
		
		return ok(carService.saveCar(dtoCarIU));
		
		
	} 

	
	
	
	
}