package com.ritik.auth.auth_app_backend.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ritik.auth.auth_app_backend.dtos.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto getByEmail(String email);
	UserDto updateUser(UserDto user,String userid);
	void deleteUser(String userid);
	UserDto getUserById(String userid);
	Iterable<UserDto> getAllUser();

}
