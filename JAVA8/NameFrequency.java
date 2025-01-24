package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NameFrequency {
	
	public static void main(String[] args) {
		 String[] names = {"Alice", "Bob", "Charlie", "Alice", "Bob", "David", "Alice"};
		 
		 Map<String, Integer> map=new HashMap<>();
		 for(String name:names) {
			map.put(name, map.getOrDefault(name, 0)+1);
		 }
		 map.forEach((k,v)->System.out.println(k+" "+v));
		 
		 System.out.println("============================");
		 Set<Entry<String, Integer>> entrySet = map.entrySet();
		 List<Entry<String, Integer>> list=new ArrayList<>(entrySet);
		 Collections.sort(list,(o1, o2) -> o2.getValue()-o1.getValue());
		 list.forEach(s->System.out.println(s.getKey()+" "+s.getValue()));
		 
		 
		 System.out.println("============================");
		 String str="i love my india i love my family india is my country";
		 String[] words=str.split("\\s+");
		 Map<String, Integer> wordFre=new HashMap<>();
		 for(String word:words) {
			 wordFre.put(word, wordFre.getOrDefault(word,0)+1);
		 }
		 
		 for(Map.Entry<String, Integer> entry:wordFre.entrySet()) {
			 if(entry.getValue()>1) {
				 System.out.println(entry.getKey()+" "+entry.getValue());
			 }
		 }
		 
		 System.out.println("using java 8===============");
		 Map<String, Long> collect = Arrays.stream(str.toLowerCase().split("\\s+"))
		 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 
		 collect.entrySet().stream().filter(entry->entry.getValue()>1)
		   .forEach((w->
		   			System.out.println(w.getKey()+"---"+w.getValue())));

		 
		 
		 System.out.println("\n repeted string character frequecy");
		// Step 1: Define a string
		 String name = "akashkumar";

		 // Step 2: Convert the string to a stream of characters, map each character to an object, and group by character with a count
		 Map<Character, Long> collect2 = name.chars() // Convert the string into an IntStream of character codes
		     .mapToObj(ch -> (char) ch) // Map each int (representing a character) to a Character object
		     .collect(Collectors.groupingBy( // Group the characters
		         ch -> ch,                  // Key: The character itself
		         Collectors.counting()      // Value: Count of occurrences of the character
		     ));

		 // Step 3: Filter the grouped results to only include characters that appear more than once
		 collect2.entrySet().stream() // Convert the map entries into a stream
		     .filter(ch -> ch.getValue() > 1) // Keep only entries where the count of the character is greater than 1
		     .forEach(charVal -> { // Loop through each filtered entry
		         // Step 4: Print each repeated character and its count
		         System.out.println(charVal.getKey() + " " + charVal.getValue()); 
		     });

	}

}
