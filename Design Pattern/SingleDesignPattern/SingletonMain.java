package com.designPattern;

public class SingletonMain {

	public static void main(String[] args) {
		SingletonDesignPatten singletonInstance1 = SingletonDesignPatten.getSingletonInstance();
		SingletonDesignPatten singletonInstance2 = SingletonDesignPatten.getSingletonInstance();
		System.out.println(singletonInstance1.hashCode());
		System.out.println(singletonInstance2.hashCode());
		
		// Verify both instances are same
        System.out.println(singletonInstance1 == singletonInstance2); // Output: true (same instance)
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        SingletonDesignPatternThreadSafe instance1 = SingletonDesignPatternThreadSafe.getInstance();
		SingletonDesignPatternThreadSafe instance2 = SingletonDesignPatternThreadSafe.getInstance();
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
		
		// Verify both instances are same
        System.out.println(instance1 == instance2);
        
	}
}
/*
 * 1. constructor should be private so that no one can call constructor if constructor will be positive then multiple object can be
 *    created  
 *    
 * 2. for creating object we create static method so that it can call with class name (and inside that method we create
 *    conditionally object)
 *    if we not create a method as a static then we have to create object for calling that method
 *    
 * 3. For creating object we create private static instance so that it can not be accessible outside of class and and as a static
 *    because inside static method we can use only static element
 *    
 * 4. Now inside method we check if instance is null then we only create object otherwise we return object
 * 
 * 5. Finally we call method using class name to insure we check hashcode of of created object
 */
