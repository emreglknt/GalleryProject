package com.emoli.galleryProject.service;

import com.emoli.galleryProject.dto.CurrencyResponse;

public interface ICurrencyService {

	public CurrencyResponse getCurrency(String startDate,String endDate);
	
}
