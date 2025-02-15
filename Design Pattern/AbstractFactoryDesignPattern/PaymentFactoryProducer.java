package com.designPattern.abstractFactoryDesign;

//Factory Producer to return the correct factory
public class PaymentFactoryProducer {

	public static PaymentFactory getFactory(String choice) {
		if(choice.equalsIgnoreCase("creditcard")) {
			return new CreditCardPaymentFactory();
		}
		else if(choice.equalsIgnoreCase("upi")) {
			return new UpiPaymentFactory();
		}
		return null;
	}
}


