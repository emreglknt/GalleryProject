package com.emoli.galleryProject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoGalleriestIU {
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private Long addressId;
	
}
