package com.exception;

public class InvaligAgeForVoting extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvaligAgeForVoting() {
		super();
	}
	
	public InvaligAgeForVoting(String message) {
		super(message);
	}
}
