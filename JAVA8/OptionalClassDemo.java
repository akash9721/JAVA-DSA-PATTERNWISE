package com.java8.Features;

import java.util.Optional;

public class OptionalClassDemo {
	public static void main(String[] args) {
		String str = null;
		Optional<String> optional = Optional.ofNullable(str);
		if (optional.isPresent())
			System.out.println("value is present");
		else {
			String def = optional.orElse("default");
			System.out.println("value is not present :" + def);
		}
	}

}
