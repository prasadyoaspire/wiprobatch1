package com.abc.springcore;

public class Triangle implements Shape {
	
	private double base;
	private double height;
	
	public void setBase(double base) {
		this.base = base;
	}	
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double area() {
		System.out.println("triangle area");
		double result = 0.5 * base * height;
		return result;
	}
}
