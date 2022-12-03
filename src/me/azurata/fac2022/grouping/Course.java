package me.azurata.fac2022.grouping;

public enum Course {
	INFO_SYSTEM(80), INFO_DESIGN(40), COMP_LIKE(60), INTE_SYSTEM(60);

	private int max;

	private Course(int max) {
		this.max = max;
	}

	/**
	 * Provides max number of the course students
	 * @return Max number of the course students
	 */
	public int getMax() {
		return max;
	}
}
