package com.emoli.galleryProject.dto;

import com.emoli.galleryProject.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class DtoGalleriest extends DtoBase{

	private String firstName;
	
	private String lastName;
	
	private DtoAddress dtoAddress;

}
