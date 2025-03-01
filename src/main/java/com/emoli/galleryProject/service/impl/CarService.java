package com.emoli.galleryProject.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emoli.galleryProject.dto.DtoCar;
import com.emoli.galleryProject.dto.DtoCarIU;
import com.emoli.galleryProject.model.Car;
import com.emoli.galleryProject.repo.CarRepository;
import com.emoli.galleryProject.service.ICarService;

@Service 
public class CarService  implements ICarService{

	@Autowired
	private CarRepository carRepository;
	
	
	private Car createCar(DtoCarIU dtoCarIU) {
		Car car = new Car();
		car.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;		
	}
	
	
	
	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
	
		DtoCar dtoCar = new DtoCar();
		
		Car savedCar = carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		
		return dtoCar;
		
	}
	
	

	
}
 