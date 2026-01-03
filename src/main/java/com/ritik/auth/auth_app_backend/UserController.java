package com.ritik.auth.auth_app_backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritik.auth.auth_app_backend.dtos.UserDto;
import com.ritik.auth.auth_app_backend.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		return ResponseEntity.ok(userService.createUser(userDto));
	}
	
	@GetMapping("fetchAll")
	public ResponseEntity<Iterable<UserDto>> getAllUsers(){
		
		return ResponseEntity.ok(userService.getAllUser());
		
	}
}
