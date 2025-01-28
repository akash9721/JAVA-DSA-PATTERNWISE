package com.java8;

import java.util.stream.Collectors;

public class FirstRepeatedCharacter {

    public static void main(String[] args) {
        String str = "Java stream API is very good concept";

        Character firstRepeating = str.chars() // Convert the string into an IntStream of character codes
            .mapToObj(ch -> (char) ch) // Convert to Stream<Character> or // Map each int (representing a character) to a Character object
            .filter(ch -> ch != ' ') // Filter out spaces
            .map(Character::toLowerCase)
            .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() > 1) // Filter characters with count > 1
            .map(entry -> entry.getKey()) // Extract keys (characters)
            .findFirst()
            .orElse(null); // Return null if no repeating character is found

        System.out.println(firstRepeating);
    }
}
