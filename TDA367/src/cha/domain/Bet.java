package cha.domain;

public class Bet {
	
	private int steps;

	/**
	 * @param steps is the value which is set for the bet.
	 */
	public Bet(int steps) {
		this.steps = steps;
	}

	/**
	 * @return the set value of the bet
	 */
	public int getBetValue() {
		return steps;
	}
}