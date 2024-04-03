package com.abc.springcore;

public class Circle implements Shape {
	
	private double radius;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		System.out.println("circle area");		
		double result = 3.14 * radius * radius;		
		return result;
	}
}
