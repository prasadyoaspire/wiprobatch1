package com.abc.springcore;

public class ShapeService {

	private Shape shape; //dependency
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public double findArea() {
		double result = shape.area();
		return result;
	}
}
