package com.crash.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceHandlerException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidatorError> validationException(MethodArgumentNotValidException e,
			HttpServletRequest request){
		ValidatorError err = new ValidatorError
		(Instant.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(), 
		e.getMessage(), "UNPROCESSABLE_ENTITY", request.getRequestURI());
		for(FieldError error : e.getBindingResult().getFieldErrors()) {
			err.addError(error.getField(), error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
}
