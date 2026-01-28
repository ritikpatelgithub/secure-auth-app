package com.ritik.auth.auth_app_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.auth.auth_app_backend.dtos.UserDto;
import com.ritik.auth.auth_app_backend.services.AuthService;
import com.ritik.auth.auth_app_backend.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
	public final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registeUser(@RequestBody UserDto userDto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(userDto));
	}

}
