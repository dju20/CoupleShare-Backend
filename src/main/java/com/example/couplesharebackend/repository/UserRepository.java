package com.example.couplesharebackend.repository;

import com.example.couplesharebackend.entity.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);

	Optional<User> findByProviderAndProviderId(String provider, String providerId);

	Optional<User> findByEmail(String email);

//    boolean existsByFriendCode(String friendCode);

//	Optional<User> findByFriendCode(String friendCode);
}
