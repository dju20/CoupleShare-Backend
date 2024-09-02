package com.example.couplesharebackend.dto.user.register;


import com.example.couplesharebackend.enums.user.Sex;
import lombok.Getter;

@Getter
public class RegisterDto {
	private String username;
	private String password;
	private String email;
	private String realName;
	private Sex sex;
}
