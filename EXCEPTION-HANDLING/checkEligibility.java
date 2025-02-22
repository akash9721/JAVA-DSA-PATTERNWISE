package com.exception;

class VotingSystem {

	public void checkEligibility(int age) {
	if(age<18) {
		throw new InvaligAgeForVoting("age is less than 18 not eligible for vote");
	  }else {
		  System.out.println("eligible for vote");
	  }
	}
}
