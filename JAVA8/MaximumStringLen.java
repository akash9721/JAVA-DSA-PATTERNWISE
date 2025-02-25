package com.java8;

import java.util.Arrays;
import java.util.List;

public class MaximumStringLen {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Hello", "welcome", "to", "java", "world");
		String stringName = words.stream().reduce((w1,w2)->w1.length()>w2.length()?w1:w2).get();
		System.out.println(stringName.length());
	}
}
