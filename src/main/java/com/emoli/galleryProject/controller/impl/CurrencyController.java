package com.emoli.galleryProject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emoli.galleryProject.controller.ICurrencyController;
import com.emoli.galleryProject.controller.RestBaseController;
import com.emoli.galleryProject.controller.RootEntity;
import com.emoli.galleryProject.dto.CurrencyResponse;
import com.emoli.galleryProject.service.impl.CurrencyService;

@RestController
@RequestMapping("/rest/api/")
public class CurrencyController extends RestBaseController implements ICurrencyController {

	
	@Autowired
	private CurrencyService currencyService;
	
	
	@GetMapping("/currency-rates")
	@Override
	public RootEntity<CurrencyResponse> getCurrency(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
		// TODO Auto-generated method stub
		return ok(currencyService.getCurrency(startDate, endDate));
	}

	
	
	
}
