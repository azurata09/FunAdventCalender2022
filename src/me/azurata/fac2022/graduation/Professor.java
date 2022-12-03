package me.azurata.fac2022.graduation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Professor {
	private final Student[] students;
	private final Student[] keep;
	private int capacity;
	
	Professor(Student[] students, boolean isPrioritized, int capacity) {
		this.students = students;
		if(isPrioritized) {
			List<Student> students_ = Arrays.asList(students);
			Collections.shuffle(students_);
			students = (Student[]) students_.toArray();
		}
		keep = new Student[capacity];
	}
}
