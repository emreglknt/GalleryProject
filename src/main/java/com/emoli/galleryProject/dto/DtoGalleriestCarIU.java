package com.emoli.galleryProject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DtoGalleriestCarIU {

	@NotEmpty
	private Long galleriestId;
	@NotEmpty
	private Long carId;
	
	
	
}
