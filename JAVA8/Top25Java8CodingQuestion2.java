package com.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Top25Java8CodingQuestion {
	public static void main(String[] args) {
		System.out.println("Top 25 java 8 interview coding question");
		
		List<Integer> nums=Arrays.asList(10,12,22,5,100,13,5,51);
		System.out.println(nums);
		
		System.out.println("1) find first element of the list");
		Integer firstElement = nums.stream().findFirst().get();
		System.out.println(firstElement);
		
		System.out.println("\n2) find the total no of element present in the list");
		long totalNo = nums.stream().count();
		System.out.println(totalNo);
		
		System.out.println("\n3) find all even and odd no");
		nums.stream().filter(x->x%2==0).collect(Collectors.toList()).forEach(s->System.out.print(s+" "));
		System.out.println();
		nums.stream().filter(x->x%2!=0).collect(Collectors.toList()).forEach(s->System.out.print(s+" "));
		
		System.out.println("\n\n4) find all no starting with 5");
		nums.stream().map(x->x.toString()).filter(x->x.startsWith("5")).forEach(x->System.out.print(x+" "));
		
		System.out.println("\n\n5) find duplicate no");
		Set<Integer> set=new HashSet<>();
		nums.stream().filter(num->!set.add(num)).forEach(s->System.out.println(s));
		
		System.out.println("\n6) find maximum and minimum value");
		int max = nums.stream().mapToInt(x->x).max().getAsInt();
		System.out.println(max);
		int min = nums.stream().mapToInt(x->x).min().getAsInt();
		System.out.println(min);
		
		System.out.println("\n7) sort ascending and descending order");
		nums.stream().sorted().forEach(x->System.out.print(x+" "));
		System.out.println();
		nums.stream().sorted(Comparator.reverseOrder()).forEach(x->System.out.print(x+" "));
		
		System.out.println("\n8) check array contain duplicate value or not");
		int arr[]= {1,2,4,5,1};
		if(Arrays.stream(arr).distinct().count()!=arr.length) {
			System.out.println("array contain duplicate value");
		}
		
		System.out.println("\n9) perform square of no and filter no greater than 50");
		nums.stream().map(x->x*x).filter(x->x>50).forEach(x->System.out.print(x+" "));
		
		System.out.println("\n\n10) sort an array and then convert the sorted array into stream");
		Arrays.sort(arr);
		Arrays.stream(arr).forEach(x->System.out.print(x+" "));
		
		System.out.println("\n\n11) convert word into uppercase");
		List<String> words=Arrays.asList("akash","pawan","vikram");
		words.stream().map(x->x.toUpperCase()).forEach(System.out::println);
		
		System.out.println("\n12) concatenate two stream");
		Stream<Integer> st1 = Stream.of(1,2,3,4);
		Stream<Integer> st2= Stream.of(30,40,50);
		Stream.concat(st1, st2).forEach(s->System.out.print(s+" "));
		
		System.out.println("\n13) print 10 random no");
		Random random=new Random();
		random.ints(10,1,30).forEach(s->System.out.print(s+" "));
		
		System.out.println("\n14) print local date time and format it");
		LocalDateTime localDateTime=LocalDateTime.now();
		System.out.println(localDateTime);
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-mm-yyyy");
		System.out.println(formatter.format(localDateTime));
		
		System.out.println("\n\n15) check if list is empty in java8 using stream \n"
				                     + "if not null iterate and print the list");
		List<String> list=Arrays.asList("abc",null,"phone");
		Optional<List<String>> optional=Optional.ofNullable(list);
		optional.ifPresentOrElse(x->x.stream().forEach(s->System.out.print(s+" ")),()->System.out.println("list contain null value"));
		
//imp	
		/* GROUPING BY ::
  		When you call collect(Collectors.groupingBy(classifier)), several things happen under the hood:
		Stream Iteration: The stream is iterated over element by element.
		Classification: For each element, the classifier function is applied. This function maps the element to a key.
		Grouping: Elements that produce the same key are grouped together. 
  			The result is a map where each key corresponds to a list of elements that share that key.
  		*/
		System.out.println("\n16) find only duplicate element with its count");
		List<String> word=Arrays.asList("akash","swagat","vineel","akash","vineel");
		Map<String, Long> map = word.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
		map.entrySet().stream().filter(x->x.getValue()>1).forEach(x->System.out.println(x.getKey()+" : "+x.getValue()));
		
		System.out.println("\n17) print the count of each character in a string");
		String str="banana";
		Map<Character, Long> mp = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(mp);
		
		System.out.println("\n18 find first unique character");
		String str2="akash";
		Entry<String, Long> first = Arrays.stream(str2.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		       .entrySet().stream().filter(x->x.getValue()==1).findFirst().orElse(null);
		if(first!=null) {
			System.out.println("first nonreated char is "+first.getKey());
		}else {
			System.out.println("no repeated char found");
		}
		
		
		
		
	}

}
