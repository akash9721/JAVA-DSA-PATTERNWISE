package com.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveAllZeroEnd {
	public static void main(String[] args) {
		List<Integer> number=List.of(1,0,-3,0,5,-2,0,8,0,-4);
		
		Map<Boolean, List<Integer>> allNum = number.stream().collect(Collectors.partitioningBy(e->e==0));
		allNum.get(false).forEach(s->System.out.print(s+" "));
		allNum.get(true).forEach(s->System.out.print(s+" "));
		
		
		System.out.println("\nusing second method");
		List<Integer> result = Stream.concat(number.stream().filter(x->x!=0), number.stream().filter(x->x==0)).collect(Collectors.toList());
		System.out.println(result);
	}

}
