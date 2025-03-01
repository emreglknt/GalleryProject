package com.emoli.galleryProject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoGalleriestIU {

	@NotNull
	private Long galleristId;
	
	@NotNull
	private Long carId;
	
		
	@NotNull
	private Long addressId;
	
	
}
