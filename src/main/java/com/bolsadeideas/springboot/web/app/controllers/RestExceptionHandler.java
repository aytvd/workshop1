package com.bolsadeideas.springboot.web.app.controllers;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bolsadeideas.springboot.web.app.models.ErrorModel;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){
		ErrorModel error = new ErrorModel("404", HttpStatus.NOT_FOUND, "Entidad no encontrada", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	

}
