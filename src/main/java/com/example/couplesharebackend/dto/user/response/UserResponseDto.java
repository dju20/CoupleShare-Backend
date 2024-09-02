package com.example.couplesharebackend.dto.user.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
	private String realName;
	private String email;
	private String sex;
	private Boolean isCouple;
}
