package com.abc.springjwt.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {

	 private String usernameOrEmail;
	 private String password;
}
