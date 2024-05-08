package com.abc.springjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.abc.springjwt.JwtTokenProvider;
import com.abc.springjwt.entity.UserEntity;
import com.abc.springjwt.model.Login;
import com.abc.springjwt.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String login(Login login) {
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                login.getUsernameOrEmail(),
	                login.getPassword()
	        ));

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String token = jwtTokenProvider.generateToken(authentication);

	        return token;
	}

	@Override
	public UserEntity register(UserEntity userEntity) {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		userEntity.setPassword(passEncoder.encode(userEntity.getPassword()));
		userRepository.save(userEntity);
		return userEntity;
	}

}
