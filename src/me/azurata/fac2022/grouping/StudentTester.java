package me.azurata.fac2022.grouping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Test sort by students' grade
 * @author azurata
 *
 */
public class StudentTester {
	public static void main(String args[]) {
		Grade[][] grades = {
				{Grade.S, Grade.S, Grade.F},
				{Grade.C, Grade.C, Grade.B},
				{Grade.A, Grade.B, Grade.B},
		};

		List<Student> students = new ArrayList<>();

		for(int i = 0; i < grades.length; i++) {
			students.add(new Student());
		}

		System.out.println(students);

		// Sort as descending sequence
		students.sort(null);
		Collections.reverse(students);

		System.out.println(students);
	}
}
