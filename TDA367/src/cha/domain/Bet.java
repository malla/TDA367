package cha.domain;

public class Bet {
	
	private boolean ifBetable;
	private int steps;

	public Bet(int steps) {
		this.steps = steps;
	}

	public int getBetValue() {
		return steps;
	}
	
	public boolean canBet(){
		return ifBetable;
	}
	
	public void setIfBetable(boolean b){
		ifBetable=b;
	}

}