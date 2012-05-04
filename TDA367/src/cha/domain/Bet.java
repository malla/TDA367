package cha.domain;

public class Bet {
	private Bet steps;
	
	public Bet(Bet steps){
		this.steps = steps;
	}
	
	public Bet getBetValue(){
		return steps;
	}
	
}