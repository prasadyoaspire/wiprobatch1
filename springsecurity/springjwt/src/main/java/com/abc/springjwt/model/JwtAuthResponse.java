package com.abc.springjwt.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthResponse {

	 private String accessToken;
	 private String tokenType = "Bearer";
}
