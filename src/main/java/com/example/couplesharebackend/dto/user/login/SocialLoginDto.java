package com.example.couplesharebackend.dto.user.login;


import com.example.couplesharebackend.enums.user.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SocialLoginDto {
	private String username;
	private String realName;
	private String email;
	private String provider;
	private String providerId;
	private UserRole role;

}
