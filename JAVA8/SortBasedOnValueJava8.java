package com.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortBasedOnValueJava8 {

	public static void main(String[] args) {
		Map <String, Integer> fruits1=new HashMap<>();
		fruits1.put("apple", 5);
		fruits1.put("kivi", 3);
		fruits1.put("litchi",10);
		fruits1.put("banana", 12);
		fruits1.put("orange", 2);
		
		LinkedHashMap<String, Integer> sortedData = fruits1.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
		
		sortedData.forEach((k,v)->System.out.println(k+" "+v));
	}
}
