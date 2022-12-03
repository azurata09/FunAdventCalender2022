package me.azurata.fac2022.grouping;

/**
 * An enum representing students' grade
 * @author azurata
 *
 */
public enum Grade {
	S(4), A(3), B(2), C(1), F(0);

	private int score;

	private Grade(int score) {
		this.score = score;
	}

	/**
	 * A method to convert Grade to int
	 * @return Returning GP(grade point)
	 */
	public int getScore() {
		return score;
	}
}
