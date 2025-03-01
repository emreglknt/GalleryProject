package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.AuthRequest;
import com.emoli.galleryProject.dto.AuthResponse;
import com.emoli.galleryProject.dto.DtoUser;
import com.emoli.galleryProject.dto.RefreshTokenRequest;

public interface IAuthController {

	
	public RootEntity<DtoUser> register(AuthRequest input);
	
	
	public RootEntity<AuthResponse> login(AuthRequest input);
	
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest request);
	
	
}
