/**
 * Reference Article: https://medium.com/@AlexanderObregon/javas-collectors-groupingby-method-explained-a5be61c80e0e
 *
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return name;
    }
}

public class GroupingByExamples {
    public static void main(String[] args) {

        System.out.println("mapping to length");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        Map<Integer,List<String>> groupedByLength1 = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength1);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> isOdd = numbers.stream()
                .collect(Collectors.groupingBy(num->num%2 !=0));
        System.out.println(isOdd);

        /**
         * DownStream Collections
         */
        List<String> names = Arrays.asList("Jake", "Sophia", "Lucas", "Mia", "Benjamin", "sharad", "Sudhanva", "Sha", "Sudo");

        Map<Integer, List<String>> groupedByLength2 = names.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(groupedByLength2);

        Map<Integer,Long> res = names.stream().collect(Collectors.groupingBy(
                String::length,
                Collectors.counting()
        ));
        System.out.println(res);

        //Collect names by their 1st letter (case-insensitive)
        Map<String, List<String>> collected = names.stream().collect(
                Collectors.groupingBy(name->Character.toString(name.charAt(0))));
        System.out.println(collected);

        List<Employee> employees = Arrays.asList(
                new Employee("Ethan", "IT", 60000),
                new Employee("Emma", "HR", 50000),
                new Employee("Noah", "IT", 70000),
                new Employee("Olivia", "Finance", 80000),
                new Employee("Liam", "HR", 55000)
        );

        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupedByDepartment);

        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(countByDept);

        Map<String, Double> collectBySalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println(collectBySalary);

        //Streams on Strings
        //Count the occurrences of letters
        String str1 = "banana";

        /**
         * Function.identity() is a static method in the java.util.function.Function interface that returns
         * a function that always returns its input argument unchanged.
         */
        Map<String, Long> frequency = str1.chars()
                                    .mapToObj(ch -> String.valueOf((char) ch))
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency " + frequency);

        String str2 = "AABBBCCCCDDDDDD";
        frequency = str2.chars()
                    .mapToObj(ch -> String.valueOf((char) ch))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequency);
        System.out.println("Printing values whose frequency is greater than 3");
        frequency.entrySet().stream().filter(x->x.getValue()>3)
                .forEach(x-> System.out.println(x.getKey()+" : "+x.getValue()));

        System.out.println("Find all repeated Chars!!");
        String input = "programming";

         List<String> collect = input.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
