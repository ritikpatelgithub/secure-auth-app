package com.ritik.auth.auth_app_backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
	
@Bean	
public ModelMapper modelMappe() {
	return new ModelMapper();
}
}
