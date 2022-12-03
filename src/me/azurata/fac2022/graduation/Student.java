package me.azurata.fac2022.graduation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
	private final Professor[] professors;

	/**
	 * Constructor of student
	 * @param professors An array of professors
	 * @param isPrioritized The variable "professors" is sorted by priority, or not
	 */
	Student(Professor[] professors, boolean isPrioritized) {
		this.professors = professors;
		if(isPrioritized) {
			List<Professor> professors_ = Arrays.asList(professors);
			Collections.shuffle(professors_);
			professors = (Professor[]) professors_.toArray();
		}
	}
	
	public Professor getIndex(int i) {
		return professors[i];
	}
}
