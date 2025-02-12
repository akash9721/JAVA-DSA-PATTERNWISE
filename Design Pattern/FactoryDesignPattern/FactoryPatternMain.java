package com.designPattern.factoryDesign;

public class FactoryPatternMain {

	public static void main(String[] args) throws IllegalAccessException {

		Pizza cheesePizza = PizzaFactory.getPizza("cheese");
		cheesePizza.prepare();

		Pizza vegPizza = PizzaFactory.getPizza("veg");
		vegPizza.prepare();
	}
}

/*
 * What is the Factory Design Pattern? Factory Pattern is a creational design
 * pattern that provides an interface for creating objects but allows subclasses
 * to alter the type of objects that will be created.
 * 
 * 🔹 Encapsulates object creation logic in one place.
 * 🔹 Promotes loose coupling between client code and object creation. 
 * 🔹 Enhances code maintainability and scalability.
 * 
 * Real-World Analogy 🎭 Pizza Store 🍕 Imagine a pizza store that makes
 * different types of pizzas: Veg Pizza, Chicken Pizza, and Cheese Pizza.
 * Instead of the customer (client code) knowing how to make these pizzas, they
 * simply request a pizza by type, and the store (Factory) prepares and delivers
 * the required pizza.
 */

/*
 * ✅ Encapsulation of Object Creation: The client doesn't need to know which
 * class to instantiate. ✅ Loose Coupling: The client depends only on the Pizza
 * interface, not specific classes. ✅ Easy Scalability: Adding a new pizza type
 * only requires updating the factory, not the client code. ✅ Better
 * Maintainability: Centralized object creation reduces duplicate code.
 */
