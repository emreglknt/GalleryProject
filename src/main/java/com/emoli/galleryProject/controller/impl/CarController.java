package com.emoli.galleryProject.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	

	@GetMapping("/list-all")
	@Override
	public RootEntity<List<DtoCar>> getAllCars() {
		return ok(carService.getAllCars());
	}

	
	
	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Void> deleteCarById(@PathVariable (name = "id",required = true)Long id) {
	    carService.deleteCarById(id); // void işlem
	    return RootEntity.ok(); // boş ama başarılı dönüş
	} 

	
	
	
}