package com.designPattern.abstractFactoryDesign;

//Abstract Factory to create Payment methods
public interface PaymentFactory {
	
		Payment getPaymentMethod(String type);
}
