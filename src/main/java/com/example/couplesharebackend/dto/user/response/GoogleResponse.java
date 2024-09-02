package com.example.couplesharebackend.dto.user.response;

import com.example.couplesharebackend.enums.user.Sex;
import java.util.Map;


public class GoogleResponse implements OAuth2Response {
	private final Map<String,Object> attribute;

	public GoogleResponse(Map<String, Object> attribute) {
		this.attribute = attribute;
	}

	@Override
	public String getProvider() {
		return "google";
	}

	@Override
	public String getProviderId() {
		return attribute.get("sub").toString();
	}

	@Override
	public String getEmail() {
		return attribute.get("email").toString();
	}

	@Override
	public String getName() {
		return attribute.get("name").toString();
	}

	@Override
	public Sex getGender() {
		return null;
	}
}
