package com.designPattern.abstractFactoryDesign;

//Implement Concrete Classes for upi Payments
public class GooglePayPayment implements Payment{

	@Override
	public void makePayment() {
		System.out.println("Payment done using google pay");
		
	}

}
