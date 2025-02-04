package academy.javapro;

import java.util.*;
import java.util.stream.*;



public class StudentStreamLab {
	public static void main(String[] args) {
		// Creating a list of students
		List<Student> students = Arrays.asList(new Student("Alice", 3.5, "Junior"), new Student("Bob", 3.8, "Senior"),
				new Student("Charlie", 2.9, "Sophomore"), new Student("David", 3.1, "Freshman"),
				new Student("Eve", 3.9, "Junior"));
		// Filtering: Students with GPA > 3.0
		List<Student> highGpaStudents = students.stream().filter(student -> student.getGpa() > 3.0)
				.collect(Collectors.toList());
		System.out.println("Students with GPA > 3.0: " + highGpaStudents);

		// Mapping: Extract names of students with GPA > 3.0
		List<String> highGpaStudentNames = students.stream().filter(student -> student.getGpa() > 3.0)
				.map(student -> student.getName()).collect(Collectors.toList());
		System.out.println("Names of students with GPA > 3.0: " + highGpaStudentNames);

		// Reducing: Calculate the average GPA of all students
		double averageGpa = students.stream().mapToDouble(student -> student.getGpa()).average().orElse(0.0);
		System.out.println("Average GPA: " + averageGpa);

		// Collecting: Collect all "Junior" students into a list
		List<Student> juniorStudents = students.stream().filter(student -> student.getCollegeYear().equals("Junior"))
				.collect(Collectors.toList());
		System.out.println("Junior students: " + juniorStudents);
	}
}
