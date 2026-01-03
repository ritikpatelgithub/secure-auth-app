package com.ritik.auth.auth_app_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resource Not Found !!");
	}
}
