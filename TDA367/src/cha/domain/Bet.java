package cha.domain;

public class Bet {
	private static Bet steps;
	
	public Bet(Bet i){
		Bet.steps = i;
	}
	
	public static Bet getBetValue(){
		return steps;
	}
	
}