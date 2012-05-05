package cha.domain;

public class Bet {
	private int steps;
	
	public Bet(int i){
		this.steps = i;
	}
	
	public int getBetValue(){
		return steps;
	}
	
}