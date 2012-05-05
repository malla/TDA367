package cha.domain;

public class Bet {
	private Bet steps;
	
	public Bet(Bet i){
		this.steps = i;
	}
	
	public Bet getBetValue(){
		return steps;
	}
	
}