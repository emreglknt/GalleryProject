package com.emoli.galleryProject.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum MessageType {

    NO_RECORD_EXIST("1004", "Kayıt Bulunamadı"),
    INVALID_REQUEST("1005", "Geçersiz istek"),
    TOKEN_IS_EXPIRED("1006" , "tokenın süresi bitmiştir"),
    UNAUTHORIZED("1007", "Yetkisiz erişim"),
    SERVER_ERROR("1008", "Sunucu hatası"),
    SUCCESS("1009", "İşlem başarılı"),
	USERNAME_NOT_FOUND("1010","Username not found"),
	USERNAME_OR_PASSWORD_INVALID("1011", "Kullanıcı adı veya şifre hatalı"),
	REFRESH_TOKEN_NOT_FOUND("1012","Refresh Token Bulunamadı"),
	REFRESH_TOKEN_EXPIRED("1013","Refresh Token Expired"),
	CURRENY_RATES_IS_OCCURED("1010" , "döviz kuru alınamadı"),
	GENERAL_EXCEPTION("9999" , "genel bir hata oluştu"),
	CAR_STATUS_IS_ALREADY_SALED("2012","Araç daha önce satılmıştır!"),
	CUSTOMER_AMOUNT_NOT_ENOUGH("1014","Bakiyeniz yeterli değildir.");
	
	
	
    private final String code;
    private final String message;
    

    MessageType(String code , String message) {
		this.code =code;
		this.message = message;
	}
    
    
}
