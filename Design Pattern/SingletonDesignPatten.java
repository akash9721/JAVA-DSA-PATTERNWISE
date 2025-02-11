package com.designPattern;

public class SingletonDesignPatten {
	
	// Eager way of creating singleton object
	/*
	 * private static SingletonDesignPatten singletonEagerInstance=new SingletonDesignPatten();
	 * 
	 * public static SingletonDesignPatten getSingletonEagerInstance() {
	 *  	return singletonEagerInstance;
	 *  }
	 */
	
	
	// 1. Private static instance (Lazy Initialization)
	private static SingletonDesignPatten singletonInstance;
	
	// 2. Private constructor to restrict instantiation
	private SingletonDesignPatten() {
		System.out.println("default constructor");
	}
	
	// 3. Public method to provide access to the instance
	public static SingletonDesignPatten getSingletonInstance() {
		if(singletonInstance==null) {
			singletonInstance = new SingletonDesignPatten();
		}
		return singletonInstance;
	}
	
}
