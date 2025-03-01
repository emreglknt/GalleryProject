package com.emoli.galleryProject.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonInclude(value = Include.NON_NULL)
public class RootEntity<T> {		//Dönen json formatını ayarlamayı sağlar

	private Integer status;
	
	private T payload;
	
	private String errorMessage;
	
	
	public static <T> RootEntity<T> ok(T payload){
		RootEntity<T> rootEntity  =new RootEntity<>();
		rootEntity.setStatus(200);
		rootEntity.setPayload(payload);
		rootEntity.setErrorMessage(null);
		return rootEntity;
	}
	
	public static <T> RootEntity<T> error(String errorMessage){
		RootEntity<T> rootEntity = new RootEntity<>();
		rootEntity.setStatus(500);
		rootEntity.setPayload(null);
		rootEntity.setErrorMessage(errorMessage);
		return rootEntity;
	}
	
	
	
	
	
	
	
}
