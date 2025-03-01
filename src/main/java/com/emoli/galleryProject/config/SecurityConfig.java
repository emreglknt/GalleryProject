package com.emoli.galleryProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.emoli.galleryProject.handler.AuthEntryPoint;
import com.emoli.galleryProject.jwt.JWTAuthenticationFilter;


@Configuration 
@EnableWebSecurity
public class SecurityConfig {

	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	

	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthEntryPoint authEntryPoint;
	
	
	
	private static final String AUTHENTICATE ="/login";
	private static final String REGISTER ="/register";
	private static final String REFRESH_TOKEN="/refreshToken";
	
	SecurityFilterChain filterChain (HttpSecurity http)throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests(request->
		request.requestMatchers(AUTHENTICATE,REGISTER,REFRESH_TOKEN).permitAll()
		.anyRequest()
		.authenticated())
		.exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
	
	
	
	
	
	
}
