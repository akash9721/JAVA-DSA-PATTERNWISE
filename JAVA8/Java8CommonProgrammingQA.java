package com.java.StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8CommonProgrammingQA {
     
	public static void main(String[] args) {
		List<Student> stu= Arrays.asList(
		        new Student(1, "Rohit", 30, "Male", "Mechnical Engineering", "Mumbai", 122, Arrays.asList("9350777395","7011008898")),
		        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("8923777395","7011345698")),
		        new Student(3, "Ankit", 25, "Female", "Mechnical Engineering", "Kerla", 164, Arrays.asList("9650777395","8011008898")),
		        new Student(4, "Satish Ray", 30, "Male", "Mechnical Engineering", "Kerla", 26, Arrays.asList("9750775395","9022008898")),
		        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("8950777396","7001108899")),
		        new Student(6, "Cheten", 24, "Male", "Mechnical Engineering", "Karnataka", 90, Arrays.asList("9628564695","8912093267")),
		        new Student(7, "Arun", 26, "Male", "Electronic Engineering", "Karnataka", 324, Arrays.asList("9832673498","8978658898")),
		        new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("8987676545","7858342109")),
		        new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("8932678954","6789453290")),
		    	new Student(10, "Shubham", 26, "Male", "Civil Engineering", "Mumbai", 98, Arrays.asList("9808765434","7898675478"))
		        );
		
		//1. find list of students whose rank is in between 50 and 100
		System.out.println("---------------------Student whose rank is in between 50 and 100");
		stu.stream().filter(s->s.getRank()>50 && s.getRank()<100).forEach(x->System.out.println(x));
		
		//2. find student who stays in karnataka and sort them by their name
		System.out.println("\n--------------------Students who stays in karnataka and sort them by their name");
		stu.stream().filter(s->s.getCity().equals("Karnataka")).sorted((a,b)->a.getFirstName().compareToIgnoreCase(b.getFirstName()))
		            .forEach(x->System.out.println(x));
		
		//3. find all department name
		System.out.println("\n--------------------Find all department name");
		stu.stream().map(x->x.getDept()).distinct().forEach(System.out::println);
		
		//4. find all the contact number
		System.out.println("\n--------------------Find all contacts numbers");
		List<String> contacts = stu.stream().flatMap(x->x.getContacts().stream()).collect(Collectors.toList());
		System.out.println(contacts);
		
		//5. group the student by dept name
		//List down the student of each department.
		System.out.println("\n--------------------Group the student by department name");
		Map<String, List<Student>> groupByStudents = stu.stream().collect(Collectors.groupingBy(Student::getDept));
		for(Map.Entry<String,List<Student>> entry: groupByStudents.entrySet()) {
			String dept = entry.getKey();
			List<Student> students = entry.getValue();
			System.out.println("Department " +dept);
			for(Student student:students) {
				System.out.println(student);
			}
		}
		
		System.out.println("\n--------------------Group the student by department name using java8 iteration");
		Map<String, List<Student>> groupBydept = stu.stream().collect(Collectors.groupingBy(Student::getDept));
		groupBydept.forEach((dept,student)->{
			System.out.println(dept);
			student.forEach(System.out::println);
		});
		
		//6. count student of each department
		System.out.println("\n--------------------Count the student by department name");
		Map<String, Long> countDept = stu.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
		System.out.println(countDept);
		
		//7. find average age of male and female student
		System.out.println("\n--------------------Average age of male and female student");
		Map<String, Double> averageAge = stu.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
		System.out.println(averageAge);
		
		//7. find highest rank in each department   
		System.out.println("\n--------------------Find highest rank in each department");
		Map<String, Student> highestRankInEachDept = stu.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getRank)), Optional::get)));
		highestRankInEachDept.forEach((a,b)->System.out.println(a+":-> "+b));
		
		//9. find student who has second rank
		System.out.println("student who has second rank");
		Student secondRankStudent = stu.stream().sorted((a,b)->a.getRank()-b.getRank()).skip(1).findFirst().get();
		System.out.println(secondRankStudent);
		
	}
	
}
