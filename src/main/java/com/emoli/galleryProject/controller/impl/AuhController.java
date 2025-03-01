package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.IAuthController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.AuthRequest;
import com.emoli.galleryProject.dto.AuthResponse;
import com.emoli.galleryProject.dto.DtoUser;
import com.emoli.galleryProject.dto.RefreshTokenRequest;
import com.emoli.galleryProject.service.IAuthenticationService;

import jakarta.validation.Valid;

 @RestController
public class AuhController extends RestBaseController implements IAuthController {


	@Autowired
	private IAuthenticationService authenticationService;
	
	
	@PostMapping("/register")
	@Override
	public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
		
		return ok(authenticationService.register(input));
		
	}

	
	
	

	@PostMapping("/login")
	@Override
	public RootEntity<AuthResponse> login(@Valid @RequestBody AuthRequest input) {
		return ok(authenticationService.login(input));
	}




	@PostMapping("/refreshToken")
	@Override
	public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
		return ok(authenticationService.refreshToken(request));
	}
	
	
	
	
	
	
	
	
	
	

}
