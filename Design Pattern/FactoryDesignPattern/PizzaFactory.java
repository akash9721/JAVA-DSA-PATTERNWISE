package com.designPattern.factoryDesign;

public class PizzaFactory {

	public static Pizza getPizza(String type) throws IllegalAccessException {
		if(type.equalsIgnoreCase("veg")) {
			return new VegPizza();
		}
		
		else if(type.equalsIgnoreCase("chicken")) {
			return new ChickenPizza();
		}
		
		else if (type.equalsIgnoreCase("cheese")){
			return new CheesePizza();
		}
		
		throw new IllegalAccessException("Invalid Pizza type "+type);
	}
}
