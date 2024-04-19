package com.abc.productservice.exception;

public class ResourceNotFoundException extends RuntimeException  {

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
