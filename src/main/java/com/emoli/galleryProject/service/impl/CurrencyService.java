package com.emoli.galleryProject.service.impl;

import java.nio.channels.NonReadableChannelException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.emoli.galleryProject.dto.CurrencyResponse;
import com.emoli.galleryProject.exception.BaseException;
import com.emoli.galleryProject.exception.ErrorMessage;
import com.emoli.galleryProject.exception.MessageType;
import com.emoli.galleryProject.service.ICurrencyService;


@Service
public class CurrencyService implements ICurrencyService{

	
	//https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A&startDate=28-02-2025&endDate=28-02-2025&type=json
	
	
	@Override
	public CurrencyResponse getCurrency(String startDate, String endDate) {
		
		String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
		String series = "TP.DK.USD.A";
		String type = "json";
		
		String endpoint = rootURL + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type="+ type;
		

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("key", "Mpta44NOhi");
		
		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		
		
		
		try {

			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<CurrencyResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<CurrencyResponse>(){} );
			
			
			if(response.getStatusCode().is2xxSuccessful()) {
				return response.getBody();
			}
			
			
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.CURRENY_RATES_IS_OCCURED,e.getMessage()));
		}
		
		
		return null;
	}

	
}
