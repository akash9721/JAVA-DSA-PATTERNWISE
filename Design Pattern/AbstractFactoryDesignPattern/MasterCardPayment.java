package com.designPattern.abstractFactoryDesign;

//Implement Concrete Classes for Credit Card Payments
public class MasterCardPayment implements Payment{

	@Override
	public void makePayment() {
		System.out.println("Payment done using mastercard");
	}

}
