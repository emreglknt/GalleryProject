package com.emoli.galleryProject.service;

import com.emoli.galleryProject.dto.AuthRequest;
import com.emoli.galleryProject.dto.AuthResponse;
import com.emoli.galleryProject.dto.DtoUser;
import com.emoli.galleryProject.dto.RefreshTokenRequest;

public interface IAuthenticationService {

	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse login(AuthRequest input);
	
	public AuthResponse refreshToken(RefreshTokenRequest input);
	
	
}
