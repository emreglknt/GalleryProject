package com.emoli.galleryProject.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyResponse {
	
	private Integer totalCount;	
	private List<CurrencyItems> items;
	
}








/*
 
 Örnek Json Response
  
  {
    "totalCount": 1,
    "items": [
        {
            "Tarih": "28-02-2025",
            "TP_DK_USD_A": "36.3652",
            "UNIXTIME": {
                "$numberLong": "1740690000"
            }
        }
    ]
}
 
*/