package me.azurata.fac2022.grouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simulator of grouping students to course at FUN
 * @author azurata
 *
 */
public class Grouping {
	private final static int STUDENT_COUNT = Arrays.asList(Course.values()).stream().mapToInt(c -> c.getMax()).sum();
	static final int SUBJECTS_NUMBER = 13;
	private static Map<String, List<Student>> grouped;

	public static void main(String args[]) {
		List<Student> students = new ArrayList<>();

		for(int i = 0; i < STUDENT_COUNT; i++) {
			students.add(new Student());
		}

		grouped = new HashMap<>();
		for(Course c : Course.values()) {
			grouped.put(c.toString(), new ArrayList<>());
		}

		System.out.println("Students: ");
		System.out.println(students);

		// Sort as descending sequence
		students.sort(null);
		Collections.reverse(students);

		System.out.println("Sorted Students: ");
		System.out.println(students);

		// Grouping
		for(Student s : students) {
			for(Course c : s.priority) {
				List<Student> course_students = grouped.get(c.toString());
				if(course_students.size() < c.getMax()) {
					course_students.add(s);
					break;
				}
			}
		}

		// Show grouped result
		System.out.println("Grouped: ");
		for(Course c : Course.values()) {
			System.out.println(c.toString() + ": ");
			System.out.println(grouped.get(c.toString()).toString());
		}

		for(Course c : Course.values()) {
			double average = grouped.get(c.toString()).stream().mapToInt(s -> s.getScoreSum()).average().getAsDouble();
			System.out.println(c.toString() + " students' GP average: " + average);
		}
	}
}
