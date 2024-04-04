package com.abc.springcore2.bean;

public class HelloBean {

	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void sayHello() {
		System.out.println("Msg: "+msg);
	}
}
