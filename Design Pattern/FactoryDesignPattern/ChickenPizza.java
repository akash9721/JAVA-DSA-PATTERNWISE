package com.designPattern.factoryDesign;

public class ChickenPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("Chicken Pizza received");
		
	}

}
