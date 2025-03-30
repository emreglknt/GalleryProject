package com.emoli.galleryProject.controller;

import com.emoli.galleryProject.dto.CurrencyResponse;

public interface ICurrencyController {

	public RootEntity<CurrencyResponse> getCurrency(String startDate,String endDate);
	
	
}
