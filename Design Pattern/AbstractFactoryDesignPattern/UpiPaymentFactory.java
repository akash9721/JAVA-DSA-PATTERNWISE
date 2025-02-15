package com.designPattern.abstractFactoryDesign;

//Factory for Credit upi Payments
public class UpiPaymentFactory implements PaymentFactory{

	@Override
	public Payment getPaymentMethod(String type) {
		if(type.equalsIgnoreCase("googlepay")) {
			return new GooglePayPayment();
		}
		else if(type.equalsIgnoreCase("phonepay")) {
			return new PhonePayPayment();
		}
		return null;
	}

}
