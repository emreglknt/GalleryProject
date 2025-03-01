package com.emoli.galleryProject.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.emoli.galleryProject.exception.BaseException;
import com.emoli.galleryProject.exception.ErrorMessage;
import com.emoli.galleryProject.exception.MessageType;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	private JWTService jwtService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String header = request.getHeader("Authorization");
		if(header==null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token;
		String userName;
		
		token= header.substring(7);

		
		try {
			
			userName = jwtService.getUserNameByToken(token);
			if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UserDetails userDetails = userDetailsService.loadUserByUsername(userName); // veritabannı kontrolü
				if(userDetails!=null && jwtService.isTokenValid(token)) {
					
					UsernamePasswordAuthenticationToken authenticationToken = new 
							UsernamePasswordAuthenticationToken(userName, null, userDetails.getAuthorities());
							
							authenticationToken.setDetails(userDetails);
							
							SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
			
		
			
			
		} catch(ExpiredJwtException ex) {
			throw new BaseException(new ErrorMessage(MessageType.TOKEN_IS_EXPIRED, ex.getMessage()));
		}
		catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, e.getMessage()));	
		}
		
		filterChain.doFilter(request, response);
		
	}

	
	
	
	
	
	
}
