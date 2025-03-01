package com.emoli.galleryProject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

	
	@NotEmpty
	private String usernName;
	
	@NotEmpty
	private String password;
	
	
	
	
	
	
	
}
