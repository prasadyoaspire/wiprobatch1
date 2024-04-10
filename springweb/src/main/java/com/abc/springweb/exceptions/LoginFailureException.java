package com.abc.springweb.exceptions;

public class LoginFailureException  extends RuntimeException{

	public LoginFailureException(String msg) {
		super(msg);
	}
}
