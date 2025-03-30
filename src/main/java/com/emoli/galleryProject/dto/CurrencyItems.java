package com.emoli.galleryProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CurrencyItems {

	
	
	@JsonProperty("Tarih") // jsondan gelen alan adını farklı kullanmak isteyince bunu kullanırız
	private String date;
	
	@JsonProperty("TP_DK_USD_A")
	private String usd;
	
	
	
	
	
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