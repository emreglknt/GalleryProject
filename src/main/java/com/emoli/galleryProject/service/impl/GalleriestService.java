package com.emoli.galleryProject.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emoli.galleryProject.dto.DtoAddress;
import com.emoli.galleryProject.dto.DtoGalleriest;
import com.emoli.galleryProject.dto.DtoGalleriestIU;
import com.emoli.galleryProject.exception.BaseException;
import com.emoli.galleryProject.exception.ErrorMessage;
import com.emoli.galleryProject.exception.MessageType;
import com.emoli.galleryProject.model.Address;
import com.emoli.galleryProject.model.Galleriest;
import com.emoli.galleryProject.repo.AddressRepository;
import com.emoli.galleryProject.repo.GalleriestRepository;
import com.emoli.galleryProject.service.IGalleriestService;

@Service
public class GalleriestService implements IGalleriestService {

	
	@Autowired
	private GalleriestRepository galleriestRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public Galleriest createGalleriest(DtoGalleriestIU dtoGalleriestIU) {

		Optional<Address> optAddress = addressRepository.findById(dtoGalleriestIU.getAddressId());
		if(optAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleriestIU.getAddressId().toString()));
		}
		
		Galleriest galleriest = new Galleriest();
		galleriest.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoGalleriestIU,galleriest);
		galleriest.setAddress(optAddress.get());
		
		return galleriest;
	}
	
	
	
	
	@Override
	public DtoGalleriest saveGalleriest(DtoGalleriestIU dtoGalleriestIU) {
		
		DtoGalleriest dtoGalleriest = new DtoGalleriest();
		DtoAddress dtoAddress = new DtoAddress();
		
		Galleriest savedGalleriest =  galleriestRepository.save(createGalleriest(dtoGalleriestIU));
		
		BeanUtils.copyProperties(savedGalleriest,dtoGalleriest);
		BeanUtils.copyProperties(savedGalleriest.getAddress(),dtoAddress);
		dtoGalleriest.setDtoAddress(dtoAddress);
		
		
		return dtoGalleriest;

	}




	@Override
	public List<DtoGalleriest> getAllGalleriests() {
		
		 List<Galleriest> galleriestList = galleriestRepository.findAll();
		
		
		 return galleriestList.stream().map(entity->{
			 
			 DtoGalleriest dtoGalleriest = new DtoGalleriest();
			 DtoAddress dtoAddress = new DtoAddress();
			 
			 BeanUtils.copyProperties(entity, dtoGalleriest);
			 
			 if(entity.getAddress() !=null) {
				 BeanUtils.copyProperties(entity.getAddress(), dtoAddress);
				 dtoGalleriest.setDtoAddress(dtoAddress);
			 }
			 
			 return dtoGalleriest;
			 
		 }).toList();
		 
		 
		 
		
	}

	
	
}
