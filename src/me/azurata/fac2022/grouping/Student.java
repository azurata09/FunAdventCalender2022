package me.azurata.fac2022.grouping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Student implements Comparable<Student> {
	private final Grade[] grades;
	public final Course[] priority;

	/**
	 * Constructor of Student class as specified grades 
	 * @param grades An array of a student's grades
	 * @param priority An array of student's course priority
	 * @throws IllegalArgumentException when grades length not mached to subject number, or priority length not matched to course values length
	 */
	public Student(Grade[] grades, Course[] priority) throws IllegalArgumentException {
		if(grades.length != Grouping.SUBJECTS_NUMBER) {
			throw new IllegalArgumentException("The argument array length named \"grades\"'s is not correct.");
		}
		if(priority.length != Course.values().length) {
			throw new IllegalArgumentException("The argument array length named \"priority\"'s is not correct.");
		}
		this.grades = grades;
		this.priority = priority;
	}

	/**
	 * Constructor of Student class to generate grades & priority as random 
	 */
	public Student() {
		Random r = new Random();

		grades = new Grade[Grouping.SUBJECTS_NUMBER];

		// Decide grades as weighted probability
		for(int i = 0; i < grades.length; i++) {
			int n = r.nextInt(100);
			if(n < 5) { // 5%
				grades[i] = Grade.F;
			} else if(n < 30) { // 25%
				grades[i] = Grade.C;
			} else if(n < 70) { // 40%
				grades[i] = Grade.B;
			} else if(n < 90) { // 20%
				grades[i] = Grade.A;
			} else { // 10%
				grades[i] = Grade.S;
			}
		}

		List<Course> priority_ = Arrays.asList(Course.values());
		Collections.shuffle(priority_);
		priority = (Course[]) priority_.toArray(new Course[priority_.size()]);
	}

	/**
	 * A method represents a student had ever failed or not
	 * @return Either this student had ever failed or never doesn't have failed
	 */
	public boolean hasFailed() {
		for(Grade g : grades) {
			if(g == Grade.F) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Calculate a student GP sum
	 * @return Sum of the student GP
	 */
	public int getScoreSum() {
		int sum = 0;
		for(Grade g : grades) {
			sum += g.getScore();
		}
		return sum;
	}

	public String toString() {
		return "Student@" + hashCode() + ";" + getScoreSum();
	}

	@Override
	public int compareTo(Student that) {
		// Failed both students, or not failed both students
		if((this.hasFailed() && that.hasFailed()) || !this.hasFailed() && !that.hasFailed()) {
			if(this.getScoreSum() == that.getScoreSum()) {
				return 0;
			}
			return this.getScoreSum() > that.getScoreSum() ? 1 : -1;
		}

		// Failed only "this"
		if(this.hasFailed()) {
			return 1;
		}

		// Failed only "that" 
		return -1;
	}
}
