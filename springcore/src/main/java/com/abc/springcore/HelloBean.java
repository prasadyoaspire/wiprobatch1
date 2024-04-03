package com.abc.springcore;

public class HelloBean {

	private String message ;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void dispaly() {
		System.out.println("Message Sent: "+message);
	}
}
