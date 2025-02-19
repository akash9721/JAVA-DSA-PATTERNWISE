package com.designPattern.decoratorDesign;

public class DecoratorDemoMain {

	public static void main(String[] args) {
		SimpleCoffe simpleCoffe = new SimpleCoffe();
		System.out.println(simpleCoffe.getDescription()+ " -> ₹"+simpleCoffe.getCost());
		
		MilkDecorator milkCoffe = new MilkDecorator(simpleCoffe);
		System.out.println(milkCoffe.getDescription()+" -> ₹"+milkCoffe.getCost());
		
		CaramelDecorator caramelCoffe = new CaramelDecorator(new SugerDecorator(new MilkDecorator(new SimpleCoffe())));
		System.out.println(caramelCoffe.getDescription()+" -> ₹"+caramelCoffe.getCost());
	}
}

+++++++++++output+++++++++++++++++++
Simple coffe -> ₹50.0
Simple coffe, milk -> ₹70.0
Simple coffe, milk, suger, caramel -> ₹110.0
