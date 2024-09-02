package com.example.couplesharebackend.service.util;

import com.example.couplesharebackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonUtilServiceImpl implements CommonUtilService {

	private final UserRepository userRepository;
	private static final int FRIEND_CODE_LENGTH = 10;
	@Override
	public String generateCoupleCode() {
		String coupleCode;
//		do{
//			coupleCode= CoupleCodeGenerator.generate(FRIEND_CODE_LENGTH);
//		}while (usersRepository.existsByFriendCode(coupleCode));

		return null;
	}
}
