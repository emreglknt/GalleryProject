package com.emoli.galleryProject.service.impl;

import java.security.AuthProvider;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.emoli.galleryProject.dto.AuthRequest;
import com.emoli.galleryProject.dto.AuthResponse;
import com.emoli.galleryProject.dto.DtoUser;
import com.emoli.galleryProject.dto.RefreshTokenRequest;
import com.emoli.galleryProject.exception.BaseException;
import com.emoli.galleryProject.exception.ErrorMessage;
import com.emoli.galleryProject.exception.MessageType;
import com.emoli.galleryProject.jwt.JWTService;
import com.emoli.galleryProject.model.RefreshToken;
import com.emoli.galleryProject.model.User;
import com.emoli.galleryProject.repo.RefreshTokenRepo;
import com.emoli.galleryProject.repo.UserRepository;
import com.emoli.galleryProject.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	
	@Autowired
	private JWTService jwtService;
	
	
	@Autowired
	private RefreshTokenRepo refreshTokenRepo;
	
	
	
	private User createUser(AuthRequest input) {
		User user = new User();
		user.setCreateTime(new Date());
		user.setUsername(input.getUsernName());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		return user;
		
	}
	
	

	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setCreateTime(new Date());
		refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setUser(user);
		return refreshToken;
	}
	
	
	
	
	
	@Override
	public DtoUser register(AuthRequest input) {
		
		DtoUser dtoUser = new DtoUser();
		User savedUser =  userRepository.save(createUser(input));
		BeanUtils.copyProperties(savedUser, dtoUser);
		
		return dtoUser;
		
	}




	@Override
	public AuthResponse login(AuthRequest input) {
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(input.getUsernName(), input.getPassword());
			authenticationProvider.authenticate(authenticationToken);
			
			Optional<User>  optUser = userRepository.findByUsername(input.getUsernName());
			
			String accessToken = jwtService.generateToken(optUser.get());
			
			RefreshToken savedRefreshToken = refreshTokenRepo.save(createRefreshToken(optUser.get()));
			
			return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());
	
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID,e.getMessage()));
		}	
	}



	
	
	
	
	@Override
	public AuthResponse refreshToken(RefreshTokenRequest input) {
		Optional<RefreshToken> optRefreshToken	=	refreshTokenRepo.findByRefreshToken(input.getRefreshToken());
		if(optRefreshToken.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND,input.getRefreshToken()));
		}
	
		if(!isRefreshTokenValid(optRefreshToken.get().getExpiredDate())) {
			throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPIRED,input.getRefreshToken()));
		}
		
		User user = optRefreshToken.get().getUser();
		
		String accessToken = jwtService.generateToken(user);
		
		RefreshToken savedRefreshToken =		refreshTokenRepo.save(createRefreshToken(user));
		
		return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());
		
	}

	
	
	public boolean isRefreshTokenValid(Date expiredDate ) {
		return new Date().before(expiredDate);
		
	}
	
	
	
	
	
	
}
