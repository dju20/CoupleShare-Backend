package com.example.couplesharebackend.controller;

import com.example.couplesharebackend.dto.user.login.CustomUserDetails;
import com.example.couplesharebackend.entity.User;
import com.example.couplesharebackend.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
	private final UserRepository userRepository;

	//test  주석
	@GetMapping("/user")
	public User getUserData(@AuthenticationPrincipal CustomUserDetails userDetails) {
		String username = userDetails.getUsername();
		Optional<User> user = userRepository.findByUsername(username);
		return user.orElse(null);
	}



	@GetMapping("/app/test")
	public String testUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
		String username = userDetails.getUsername();
		return username;
	}

}