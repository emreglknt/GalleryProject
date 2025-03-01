package com.emoli.galleryProject.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoCar;
import com.emoli.galleryProject.dto.DtoGalleriest;
import com.emoli.galleryProject.dto.DtoGalleriestCar;
import com.emoli.galleryProject.dto.DtoGalleriestCarIU;
import com.emoli.galleryProject.exception.BaseException;
import com.emoli.galleryProject.exception.ErrorMessage;
import com.emoli.galleryProject.exception.MessageType;
import com.emoli.galleryProject.model.Car;
import com.emoli.galleryProject.model.Galleriest;
import com.emoli.galleryProject.model.GalleriestCar;
import com.emoli.galleryProject.repo.CarRepository;
import com.emoli.galleryProject.repo.GalleriestCarRepository;
import com.emoli.galleryProject.repo.GalleriestRepository;
import com.emoli.galleryProject.service.IGalleristCarService;

@Service
public class GalleriestCarService implements IGalleristCarService{

	
	@Autowired
	private GalleriestCarRepository galleriestCarRepository;
	
	@Autowired
	private CarRepository carRepository;
		
	@Autowired
	private GalleriestRepository galleriestRepository;

	
	
	private GalleriestCar createGalleriestCar(DtoGalleriestCarIU dtoGalleriestCarIU) {
		
		Optional<Car> optCar = 	carRepository.findById(dtoGalleriestCarIU.getCarId());
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleriestCarIU.getCarId().toString()));
		}
		
		
		Optional<Galleriest> optGalleriest = galleriestRepository.findById(dtoGalleriestCarIU.getGalleriestId());
		if(optGalleriest.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleriestCarIU.getGalleriestId().toString()));
		}
		
		GalleriestCar galleriestCar = new GalleriestCar();
		
		galleriestCar.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoGalleriestCarIU, galleriestCar);
		
		galleriestCar.setCar(optCar.get());
		galleriestCar.setGalleriest(optGalleriest.get());
		
		return galleriestCar;
		
		
	}
	
	
	
	@Override
	public DtoGalleriestCar saveGalleriestCar(DtoGalleriestCarIU dtoGalleriestCarIU) {
		
		DtoGalleriestCar dtoGalleriestCar = new DtoGalleriestCar();
		DtoCar dtoCar  = new DtoCar();
		DtoGalleriest dtoGalleriest = new DtoGalleriest();
		
		DtoAddress dtoAddress  = new DtoAddress();
		
		
	GalleriestCar savedGalleriestCar = 	galleriestCarRepository.save(createGalleriestCar(dtoGalleriestCarIU));
		
		
	BeanUtils.copyProperties(savedGalleriestCar, dtoGalleriestCar);
	BeanUtils.copyProperties(savedGalleriestCar.getCar(),dtoCar);
	BeanUtils.copyProperties(savedGalleriestCar.getGalleriest(),dtoGalleriest);
	BeanUtils.copyProperties(savedGalleriestCar.getGalleriest().getAddress(), dtoAddress);



		dtoGalleriest.setDtoAddress(dtoAddress);
		
		dtoGalleriestCar.setCar(dtoCar);
		dtoGalleriestCar.setGalleriest(dtoGalleriest);
			
	
		return dtoGalleriestCar;
		
	}
	
	
	

}
