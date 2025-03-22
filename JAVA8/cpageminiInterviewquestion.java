package com.java8;

import java.util.stream.Collectors;

public class PrintDuplicateFromString {
	public static void main(String[] args) {
		String text="makerandchecker";
		duplicateChars(text);
		System.out.println();
		firstRepeatingChar(text);
		
	}

	private static void firstRepeatingChar(String text) {
		Character firstRepeatingChar = text.chars()
		.mapToObj(ch->(char)ch)
		.collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(val->val.getValue()>1)
		.map(key->key.getKey())
		.findFirst()
		.orElse(null);
		System.out.println(firstRepeatingChar);
	}

	private static void duplicateChars(String text) {
		text.chars()
		.mapToObj(ch->(char)ch)
		.collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(val->val.getValue()>1)
		.map(key->key.getKey())
		.collect(Collectors.toList())
		.forEach(x->System.out.print(x+" "));
	}

}
