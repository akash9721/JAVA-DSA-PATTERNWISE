package com.designPattern.factoryDesign;

public class VegPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("Veg Pizza received");
		
	}

}
