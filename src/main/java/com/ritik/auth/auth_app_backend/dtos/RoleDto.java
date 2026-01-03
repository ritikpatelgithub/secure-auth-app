package com.ritik.auth.auth_app_backend.dtos;

import java.util.UUID;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
	private UUID id=UUID.randomUUID();
	@Column(unique=true,nullable = false)
	private String name;
}
