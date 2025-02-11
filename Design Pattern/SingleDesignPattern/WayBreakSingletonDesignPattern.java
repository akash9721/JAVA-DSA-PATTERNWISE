package com.designPattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WayBreakSingletonDesignPattern {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, CloneNotSupportedException {
		
		SingletonDesignPatten originalSingleInstance = SingletonDesignPatten.getSingletonInstance();
		SingletonDesignPatten duplicateSingleInstance = SingletonDesignPatten.getSingletonInstance();
		System.out.println("hashcode of originalSingleInstance "+originalSingleInstance.hashCode());
		System.out.println("hashcode of duplicateSingleInstance "+duplicateSingleInstance.hashCode());
		
		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("using reflection api");
		Class<?> singletonClass = Class.forName("com.designPattern.SingletonDesignPatten");
		Constructor<SingletonDesignPatten> constructor = (Constructor<SingletonDesignPatten>) singletonClass.getDeclaredConstructor();
		constructor.setAccessible(true); //making constructor public for accessible
		
		SingletonDesignPatten reflectionInstace = constructor.newInstance();
		System.out.println("hashcode of originalSingleInstance "+originalSingleInstance.hashCode());
		System.out.println("hashcode of reflectionInstace "+reflectionInstace.hashCode());
		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("using serialization");
		FileOutputStream fos=new FileOutputStream(new File("abc.txt"));
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(originalSingleInstance);
		oos.close();
		System.out.println("object serialize");
		
		FileInputStream fis=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		SingletonDesignPatten serializeInstance=(SingletonDesignPatten)ois.readObject();
		
		System.out.println("hashcode of originalSingleInstance "+originalSingleInstance.hashCode());
		System.out.println("hashcode of serializeInstance "+serializeInstance.hashCode());
		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("using clone method");
		
		SingletonDesignPatten clonableInstance= (SingletonDesignPatten) originalSingleInstance.clone();
		System.out.println("hashcode of originalSingleInstance "+originalSingleInstance.hashCode());
		System.out.println("hashcode of clonableInstance "+clonableInstance.hashCode());
		
		
		
		
	}
}
