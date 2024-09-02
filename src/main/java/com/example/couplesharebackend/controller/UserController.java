package com.example.couplesharebackend.controller;

import com.example.couplesharebackend.dto.user.register.RegisterDto;
import com.example.couplesharebackend.service.user.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserServiceImpl usersServiceImpl;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {

		try {
			usersServiceImpl.saveUser(registerDto);
			return ResponseEntity.ok().build();
		} catch (Exception exception) {
			return ResponseEntity.badRequest().build();
		}
	}



}
