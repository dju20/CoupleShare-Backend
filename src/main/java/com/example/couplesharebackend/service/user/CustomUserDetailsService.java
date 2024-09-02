package com.example.couplesharebackend.service.user;

import com.example.couplesharebackend.dto.user.login.CustomUserDetails;
import com.example.couplesharebackend.entity.User;
import com.example.couplesharebackend.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userData = userRepository.findByUsername(username);

		if(userData.isPresent()){
			return new CustomUserDetails(userData.get());
		}
		return null;
	}
}
