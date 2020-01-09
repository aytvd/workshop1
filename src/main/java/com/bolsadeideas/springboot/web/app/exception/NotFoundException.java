package com.bolsadeideas.springboot.web.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Elemnt otro not found")
public class NotFoundException extends RuntimeException{

}
