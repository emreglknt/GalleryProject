package com.emoli.galleryProject.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.emoli.galleryProject.exception.BaseException;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;



@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<ApiError<?>> handleBaseException(BaseException ex,WebRequest request) {
		
		return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
	}
	
	
	
	
	

	
	
	public <E> ApiError<E> createApiError(E message, WebRequest request) {
		ApiError<E> apiError = new ApiError<>();
		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

		Exception<E> exception = new Exception<>();
		exception.setPath(request.getDescription(false).substring(4));
		exception.setCreateTime(new Date());
		exception.setMessage(message);
		exception.setHostName(getHostName());

		apiError.setException(exception);

		return apiError;
	}
	
	
	
	private String getHostName() {
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	
	
	//bu kısım valid olmayan field ların hatalarını handle etmek için   ÖR: şifreniz 8 haneli olmalı burası boş geçilemez gibi 
	
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
		Map<String, List<String>> map = new HashMap<>();
		for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) objError).getField();

			if (map.containsKey(fieldName)) {
				map.put(fieldName, addValue(map.get(fieldName), objError.getDefaultMessage()));
			} else {
				map.put(fieldName, addValue(new ArrayList<>(), objError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(map, request));
	}

	
	
	private List<String> addValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
