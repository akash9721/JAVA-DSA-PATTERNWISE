package com.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SecondHighestSalary {

	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<>();
		map.put("anil", 1000);
		map.put("bhavna", 1300);
		map.put("michel", 1500);
		map.put("tom", 1600);
		map.put("ankit", 1200);
		map.put("danial", 1700);
		map.put("james", 1400);
		
		Entry<String, Integer> secondHighestElement = map.entrySet().stream()
			.sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
		          .collect(Collectors.toList())
		            .get(1);
		System.out.println(secondHighestElement);

		//or

		Entry<String, Integer> secondHighestElement = map.entrySet().stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		            .collect(Collectors.toList())
		               .get(1);
		System.out.println(secondHighestElement);
	}
}
