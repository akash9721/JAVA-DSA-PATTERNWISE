package com.java8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateFromList {

	public static void main(String[] args) {
		List<Integer> numbers=List.of(1,2,3,4,5,3,2,1);
		Set<Integer> set=new HashSet<>();
		Set<Integer> output = numbers.stream().filter(e->!set.add(e)).collect(Collectors.toSet());
		System.out.println(output);
		
		System.out.println("\nUsing second method");
		List<Integer> outpu2 = numbers.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
			.entrySet().stream()
			.filter(x->x.getValue()>1)
			.map(x->x.getKey())
			.collect(Collectors.toList());
		System.out.println(outpu2);
		
	}
}
