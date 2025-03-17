package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenList {

	public static void main(String[] args) {
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );
        
        System.out.println();
        List<Integer> list2 = nestedList.stream().flatMap(x->x.stream()).collect(Collectors.toList());
        System.out.println(list2);
        
	}
}
