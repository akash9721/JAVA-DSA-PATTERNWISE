package com.java8;

import java.util.List;
import java.util.stream.Collectors;

public class AllRepeatedCharacter {
	
	    public static void main(String[] args) {
	        String str = "Java stream API is very good concept";
	        
	        List<Character> result = str.chars()
	        .mapToObj(ch->(char)ch)
	        .filter(ch->ch!=' ')
	        .map(Character::toLowerCase)
	        .collect(Collectors.groupingBy(x->x,Collectors.counting()))
	        .entrySet()
	        .stream()
	        .filter(val->val.getValue()>1)
	        .map(val->val.getKey())
	        .collect(Collectors.toList());
	        System.out.println(result);

	    }
	}

