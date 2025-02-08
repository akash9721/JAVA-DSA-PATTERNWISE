package com.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SecondHighestSalaryInRepetedData {

	public static void main(String[] args) {
		
		Map<String, Integer> map=new HashMap<>();
		map.put("anil", 1000);
		map.put("bhavna", 1300);
		map.put("michel", 1200);
		map.put("tom", 1200);
		map.put("ankit", 1200);
		map.put("danial", 1000);
		map.put("james", 1300);
		
		Entry<Integer, List<String>> result = map.entrySet().stream()
		.collect(Collectors.groupingBy(Map.Entry::getValue,
				Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
		.entrySet()
		.stream()
		.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
		.collect(Collectors.toList())
		.get(1);
		
		System.out.println(result);
	}
}
