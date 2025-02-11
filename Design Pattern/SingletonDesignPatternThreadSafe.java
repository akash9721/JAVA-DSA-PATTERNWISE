package com.designPattern;

public class SingletonDesignPatternThreadSafe {

	private static SingletonDesignPatternThreadSafe instance;
	
	private SingletonDesignPatternThreadSafe() {
		System.out.println("singleton");
	}
	
	public static SingletonDesignPatternThreadSafe getInstance() {
		
		if(instance==null) { // First check (without locking)
			synchronized (SingletonDesignPatternThreadSafe.class) {
				if(instance==null) { // Second check (with locking)
					instance=new SingletonDesignPatternThreadSafe();
				}
			}
		}
		return instance;
	}
}
