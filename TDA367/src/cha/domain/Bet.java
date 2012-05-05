package cha.domain;

public class Bet {

	
	public Bet(Bet i){
		this.steps = i;
	}
	
	private static Bet steps;
	
	
	public static Bet getBetValue(){

		return steps;
	}
	
}