package com.emoli.galleryProject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSaledCarIU {

	@NotNull
	private Long customerId;
	@NotNull
	private Long carId;
	@NotNull
	private Long galleryId;
	
	
}
