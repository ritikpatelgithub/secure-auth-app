package com.ritik.auth.auth_app_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
		return ResponseEntity.ok(userService.getByEmail(email));
	}
	
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable("userId") String userId) {
		userService.deleteUser(userId);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUSer(@RequestBody UserDto useDto,@PathVariable("userId") String userId) {
		return ResponseEntity.ok(userService.updateUser(useDto, userId));
	}
	
	@GetMapping("/getId/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") String Id){
		return ResponseEntity.ok(userService.getUserById(Id));
	}
	
	
	
}
