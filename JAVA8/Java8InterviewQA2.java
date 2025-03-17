package com.java8.Features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeApp {

	public static void main(String[] args) {

		List<Employee> emp = Arrays.asList(new Employee(28, "John", 50000, "HR", "Male", 2014),
				new Employee(26, "Roma", 51000, "Tech", "Female", 2015),
				new Employee(31, "Mathew", 60000, "HR", "Male", 2017),
				new Employee(29, "John", 89000, "Ops", "Male", 2014),
				new Employee(24, "Linda", 3000, "HR", "Female", 2016),
				new Employee(26, "Michel", 95000, "Tech", "Male", 2013),
				new Employee(37, "Ram", 48000, "Tech", "Male", 2014),
				new Employee(29, "Agnes", 73000, "Ops", "Female", 2017),
				new Employee(30, "Jessica", 65000, "Ops", "Female", 2013),
				new Employee(31, "Julie", 56000, "Ops", "Female", 2017),
				new Employee(21, "xiaodong", 50600, "Ops", "Male", 2019),
				new Employee(32, "Liping", 50300, "Tech", "Female", 2013),
				new Employee(23, "Garry", 40000, "Tech", "Male", 2014),
				new Employee(40, "Harry", 170708, "Tech", "Female", 2017));

		System.out.println(" 1. Get details of highest paid employee");
		Employee employee = emp.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))).get();
		System.out.println(employee.getName());

		System.out.println("\n2. List of employee who joined after 2014");
		List<String> empwhojoinafter2014 = emp.stream().filter(s -> s.getYearOfjoining() > 2014).map(s -> s.getName())
				.collect(Collectors.toList());
		System.out.println(empwhojoinafter2014);

		System.out.println("\n3. No of male and female employee in company");
		long maleemp = emp.stream().filter(s -> s.getGender().equals("Male")).count();
		System.out.println("No of male employee: " + maleemp);
		long femaleemp = emp.stream().filter(s -> s.getGender().equals("Female")).count();
		System.out.println("No of female employee: " + femaleemp);

		System.out.println("\n4.Average salary of all employee");
		Double avgSal = emp.stream().collect(Collectors.averagingInt(Employee::getSalary));
		System.out.println(avgSal);

		System.out.println("\n5. Name of all departments");
		List<String> deptName = emp.stream().map(s -> s.getDepartment()).distinct().collect(Collectors.toList());
		System.out.println(deptName);

		System.out.println("\n6. Average of male and female employee");
		Map<String, Double> avgMaleandFemaleemp = emp.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getSalary)));
		System.out.println(avgMaleandFemaleemp);

		System.out.println("\n7. Who has the most working experience in the companmy");
		String mostExperienceEmp = emp.stream().sorted((a, b) -> a.getYearOfjoining() - b.getYearOfjoining())
				.findFirst().get().getName();
		System.out.println(mostExperienceEmp);

		System.out.println("\n8. Details of youngest female employee from HR department");
		String youngestFemaleEmp = emp.stream()
				.filter(x -> x.getGender().equals("Female") && x.getDepartment().equals("HR"))
				.sorted((a, b) -> a.getAge() - b.getAge()).findFirst().get().getName();
		System.out.println(youngestFemaleEmp);

		System.out.println("\n9. Find employee who has 3rd highest salary");
		String thirdHighestSalEmpName = emp.stream().sorted((a, b) -> b.getSalary() - a.getSalary())
				.map(Employee::getName).skip(2).findFirst().get();
		System.out.println(thirdHighestSalEmpName);

		System.out.println("\n10. Sort employee details based on salary");
		emp.stream().sorted((a, b) -> a.getSalary() - b.getSalary()).forEach(System.out::println);

		System.out.println("\n11. Highest salary in each department");
		Map<String, Employee> highestSalDepartmentWise = emp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
		System.out.println(highestSalDepartmentWise);

		System.out.println("\n12. No of employee in each department");
		Map<String, Long> empInEachDept = emp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(empInEachDept);

	}
}
