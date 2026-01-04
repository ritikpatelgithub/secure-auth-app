package com.ritik.auth.auth_app_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ritik.auth.auth_app_backend.dtos.ErrorResponse;

public class GlobalExceptionHandler {
	  @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
	        ErrorResponse internalServerError = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND, 404);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(internalServerError);
	    }
}
