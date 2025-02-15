package com.designPattern.abstractFactoryDesign;

//Factory for Credit Card Payments
public class CreditCardPaymentFactory implements PaymentFactory{

	@Override
	public Payment getPaymentMethod(String type) {
		if(type.equalsIgnoreCase("visa")) {
			return new VisaPayment();
		}
		else if(type.equalsIgnoreCase("mastercard")) {
			return new MasterCardPayment();
		}
		return null;
	}

}
