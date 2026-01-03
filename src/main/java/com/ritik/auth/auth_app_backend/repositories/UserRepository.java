package com.ritik.auth.auth_app_backend.repositories;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ritik.auth.auth_app_backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	 Optional<User> findByEmail(String email);
	 boolean existsByEmail(String email);
}
