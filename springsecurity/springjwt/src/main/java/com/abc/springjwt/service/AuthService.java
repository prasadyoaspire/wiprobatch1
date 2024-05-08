package com.abc.springjwt.service;

import com.abc.springjwt.entity.UserEntity;
import com.abc.springjwt.model.Login;

public interface AuthService {

	String login(Login login);
	
	UserEntity register(UserEntity userEntity);
}
