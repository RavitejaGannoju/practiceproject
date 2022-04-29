package com.example.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
	
	

	public ExceptionResponse(Date dateTime, String message, String details) {
		super();
		this.dateTime = dateTime;
		this.message = message;
		this.details = details;
	}

	private Date dateTime;
	
	private String message;
	
	private String details;
	
}
