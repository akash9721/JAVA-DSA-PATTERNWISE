package com.designPattern.abstractFactoryDesign;

public class AbstractFactoryDesignMain {
	public static void main(String[] args) {
		PaymentFactory upiPaymentFactory = PaymentFactoryProducer.getFactory("upi");
		Payment googlepay = upiPaymentFactory.getPaymentMethod("googlepay");
		googlepay.makePayment();
		
		PaymentFactory creditCardFactory = PaymentFactoryProducer.getFactory("creditcard");
		Payment visa = creditCardFactory.getPaymentMethod("visa");
		visa.makePayment();
	}
}
