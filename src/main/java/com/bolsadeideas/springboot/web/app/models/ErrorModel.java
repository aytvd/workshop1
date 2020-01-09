package com.bolsadeideas.springboot.web.app.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorModel {
	
	private String status;
	
	private HttpStatus httpStatus;
	
	private LocalDateTime timestamp;
	
	private String message;
	
	private String details;
	
	public ErrorModel(String status, HttpStatus httpStatus, String message, String details) {
		this.status = status;
		this.httpStatus = httpStatus;
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
