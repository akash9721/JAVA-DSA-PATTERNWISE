package com.java.StreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Java8InterviewQA {
	
	public static void main(String[] args) {
		List<Student> stu = Arrays.asList(
	            new Student(1, "Alice", 22, "Female", "CSE", "New York", 1, Arrays.asList("1234567890", "9876543210")),
	            new Student(2, "Bob", 24, "Male", "ECE", "Los Angeles", 3, Arrays.asList("1234561234", "4567891234")),
	            new Student(3, "Charlie", 23, "Male", "CSE", "Chicago", 2, Arrays.asList("7894561230", "1237894560")),
	            new Student(4, "Diana", 21, "Female", "MECH", "Houston", 5, Arrays.asList("4561237890", "3216549870")),
	            new Student(5, "Edward", 25, "Male", "ECE", "Phoenix", 4, Arrays.asList("7418529630", "8529637410")),
	            new Student(6, "Fiona", 22, "Female", "CSE", "San Francisco", 1, Arrays.asList("9638527410", "1597534862")),
	            new Student(7, "George", 26, "Male", "MECH", "New York", 6, Arrays.asList("8524569630", "6543217890")),
	            new Student(8, "Hannah", 24, "Female", "CIVIL", "Los Angeles", 2, Arrays.asList("9517538524", "2583691470")),
	            new Student(9, "Ian", 23, "Male", "CIVIL", "Chicago", 3, Arrays.asList("9873216540", "7419638520")),
	            new Student(10, "Jenny", 21, "Female", "CSE", "New York", 7, Arrays.asList("3692581470", "1472583690"))
	        );

	        // Print all student data (Optional, for verification)
	        //stu.forEach(System.out::println);
		Double d1=10.0/0.0;
		System.out.println(d1.isInfinite());
	        
	     //Easy Questions:
		    //Filter all students from the CSE department.
		    System.out.println();
	        stu.stream().filter(s->s.getDept().equals("CSE")).forEach(System.out::println);
	        
		    //Get a list of all students’ names.
	        System.out.println();
	        List<String> studentsNames = stu.stream().map(s->s.getFirstName()).collect(Collectors.toList());
	        System.out.println(studentsNames);
	        
		    //Find the count of students in each department.
	        System.out.println();
	        Map<String, Long> countStudentByDept = stu.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));
	        countStudentByDept.forEach((k,v)->System.out.println(k+" "+v));
	        
		    //Check if there are any students from Houston.
	        System.out.println();
	        boolean anyMatch = stu.stream().anyMatch(s->s.getCity().equals("Houston"));
	        System.out.println(anyMatch);
	        
		    //Get a list of unique cities where students live.
	        System.out.println();
	        stu.stream().map(s->s.getCity()).distinct().forEach(s->System.out.println(s));
	        
		    //Sort all students by their rank in ascending order.
	        System.out.println();
	        stu.stream().sorted((s1,s2)->s1.getRank()-s2.getRank()).forEach(s->System.out.println(s));
	        
		    //Filter all female students and collect their names into a list.
	        System.out.println();
	        List<String> femaleStudent = stu.stream().filter(s->s.getGender().equals("Female")).map(s->s.getFirstName()).collect(Collectors.toList());
	        System.out.println(femaleStudent);
	        
		    //Check if all students in the CIVIL department have ranks less than 5.
	        System.out.println();
	        boolean allMatch = stu.stream().filter(s->s.getDept().equals("CIVIL")).allMatch(s->s.getRank()<5);
	        System.out.println(allMatch);
	        
		    //Find the total number of students.
	        System.out.println();
	        long noofStudents = stu.stream().count();
	        System.out.println(noofStudents);
	        
		    //Convert all student names to uppercase and collect them in a list.
	        System.out.println();
	        List<String> stuNames = stu.stream().map(s->s.getFirstName().toUpperCase()).collect(Collectors.toList());
	        System.out.println(stuNames);
	                
	     // Moderate Questions:
	        System.out.println("\nModerate Questions:------------------------------------------------------------------------");
	        // Group students by department and print the student count in each department.
	        System.out.println();
	        stu.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting())).
	                     forEach((x,y)->System.out.println(x+ "->"+y));
	        
	        // Find the student with the highest rank in the ECE department.
	        System.out.println();
	        Student student1 = stu.stream().filter(s->s.getDept().equals("ECE")).sorted((x,y)->x.getRank()-y.getRank()).findFirst().get();
	        System.out.println(student1);
	        Student highestRankECE = stu.stream()
	        	    .filter(s -> "ECE".equals(s.getDept()))
	        	    .min(Comparator.comparingInt(Student::getRank))
	        	    .orElse(null);
	        	System.out.println(highestRankECE);

	        
	        // Get a list of all unique contact numbers of students.
	        System.out.println();
	        List<String> uniqueContact = stu.stream().flatMap(s->s.getContacts().stream()).distinct().collect(Collectors.toList());
	        System.out.println(uniqueContact);
	        
	        //	Count the number of male and female students.
	        System.out.println();
	        stu.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.counting())).forEach((x,y)->System.out.println(x+" "+y));
	        
	        //	Find the average age of students in the CSE department.
	        System.out.println();
	        double avg1 = stu.stream().filter(s->s.getDept().equals("CSE")).mapToInt(Student::getAge).average().orElse(0);
	        System.out.println(avg1);
	        System.out.println("               or");
	        Double avg2 = stu.stream().filter(s->s.getDept().equals("CSE")).collect(Collectors.averagingDouble(Student::getAge));
	        System.out.println(avg2);
	        
	        //	Get the name of the student with the lowest rank in MECH.
	        System.out.println();
	        Student stuName1 = stu.stream().sorted((x,y)->y.getRank()-x.getRank()).filter(s->s.getDept().equals("MECH")).findFirst().get();
	        System.out.println(stuName1.getFirstName());
	        
	        //	Get a map of department names and the list of students in each department.
	        System.out.println();
	        Map<String, List<Student>> collect = stu.stream().collect(Collectors.groupingBy(Student::getDept));
	        collect.forEach((dept,studentlist)->{
	        	System.out.println("++++++++ In "+dept+" department ++++++++");
	        	studentlist.stream().map(x->x.getFirstName()).forEach(s->System.out.println(s));
	        	System.out.println();
	        });
	        
	        //	Sort students by rank and group them by gender.
	        System.out.println();
	        Map<String, List<Student>> collect2 = stu.stream().sorted((s1,s2)->s1.getRank()-s2.getRank()).collect(Collectors.groupingBy(Student::getGender));
	        collect2.forEach((gender,studentlist)->{
	        	System.out.println("++++++++ "+gender+" ++++++++");
	        	studentlist.stream().map(x->x.getFirstName()).forEach(s->System.out.println(s));
	        	System.out.println();
	        });
	        
	        
	        //	Find the oldest student in the list and print their details.
	        System.out.println();
	        Student oldstu = stu.stream().sorted((s1,s2)->s2.getAge()-s1.getAge()).findFirst().orElse(null);
	        System.out.println(oldstu);
	        
	        //	Get the first name of the youngest student in the New York city.
	        System.out.println();
	        Student youngestStu = stu.stream().filter(x->x.getCity().equals("New York")).sorted((s1,s2)->s1.getAge()-s2.getAge()).findFirst().get();
	        System.out.println(youngestStu.getFirstName());
	        
	      //Hard Questions:
	        
	        System.out.println("Hard Questions---------------------------------------------------------------");
	        //	Find the department with the highest number of students.
	        System.out.println();
	        Map<String, Long> collect3 = stu.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));	        
	        
	        //	Find the average rank of students grouped by department.
	        System.out.println();
	        Map<String, Double> averageRankByDept = stu.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.averagingInt(Student::getRank)));
	        System.out.println(averageRankByDept);
	        
	        //	Partition students into two groups: those with ranks less than 3 and others.
	        System.out.println();
	        Map<Boolean, List<Student>> partitionedByRank = stu.stream()
	        	    .collect(Collectors.partitioningBy(s -> s.getRank() < 3));
	        	System.out.println("Students with rank < 3:");
	        	partitionedByRank.get(true).forEach(System.out::println);
	        	System.out.println("\nStudents with rank >= 3:");
	        	partitionedByRank.get(false).forEach(System.out::println);

	        
	        
	        //	List all students who have more than one contact number.
	        	System.out.println();
	        	stu.stream().filter(s->s.getContacts().size()>1).forEach(o->System.out.println(o));
	        
	        //	Find the city with the youngest student.
	        System.out.println();
	        String city = stu.stream().min(Comparator.comparingInt(Student::getAge)).map(x->x.getCity()).get();
	        System.out.println(city);
	        
	        //	Get the department where the student with the highest rank (across all departments) belongs.
	        System.out.println();
	        String dept = stu.stream().min(Comparator.comparingInt(Student::getRank)).map(x->x.getDept()).get();
	        System.out.println(dept);
	        
	        //	Group students by gender, and for each gender, find the student with the lowest rank.
	        System.out.println();
	        Map<String, Student> collect5 = stu.stream().collect(Collectors.groupingBy(Student::getGender,
	        		Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getRank)), Optional::get)));
	        System.out.println(collect5);
	        
	        //	Print department names and the names of students sorted by rank in each department.
	        System.out.println();
	        Map<String, List<Student>> collect6 = stu.stream().collect(Collectors.groupingBy(Student::getDept));
	        collect6.forEach((dep,stuN)->{
	        	System.out.println(dep+"...");
	        	stuN.stream().sorted((x,y)->x.getRank()-y.getRank()).forEach(System.out::println);
	        	System.out.println();
	        });
	        
	        //	Find all students from Chicago and flatten their contact lists into a single list of contacts.
	        System.out.println();
	        List<String> contactList = stu.stream().filter(s->s.getCity().equals("Chicago")).
	        		                   flatMap(x->x.getContacts().stream()).collect(Collectors.toList());
	        System.out.println(contactList);
	        
	        //	Calculate the total number of contacts across all students.
	        System.out.println();
	        long noOfTotalContact = stu.stream().flatMap(x->x.getContacts().stream()).count();
	        System.out.println(noOfTotalContact);
	        


	}

}
