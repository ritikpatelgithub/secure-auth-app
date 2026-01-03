package com.ritik.auth.auth_app_backend.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritik.auth.auth_app_backend.dtos.UserDto;
import com.ritik.auth.auth_app_backend.entities.Provider;
import com.ritik.auth.auth_app_backend.entities.User;
import com.ritik.auth.auth_app_backend.exceptions.ResourceNotFoundException;
import com.ritik.auth.auth_app_backend.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		  if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
		        throw new IllegalArgumentException("Email cannot be null or empty");
		    }
		  if(userRepository.existsByEmail(userDto.getEmail())) {
			  throw new IllegalArgumentException("Email already exist");
		  }
		  
		  User user=modelMapper.map(userDto, User.class);
		  user.setProvider(userDto.getProvider()!=null ?userDto.getProvider() :Provider.LOCAL);
		  User savedUser=userRepository.save(user);
		  
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id "));
        return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUse(UserDto user, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDto getUserById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		  return userRepository.findAll()
		            .stream()
		            .map(user -> modelMapper.map(user, UserDto.class))
		            .toList();
	}
	
	

}
