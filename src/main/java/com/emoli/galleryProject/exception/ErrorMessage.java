package com.emoli.galleryProject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	
	private MessageType messageType;
	private String errorDetail;
	

	
	
	
	public String prepareErrorMessage() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(messageType.getMessage());
		if(this.errorDetail!=null) {
			builder.append(" : "+errorDetail);
		}
		
		return builder.toString();
	}
	
	
	
	
}
