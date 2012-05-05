package cha.domain;

public class Bet {
<<<<<<< HEAD
	private int steps;
	
	public Bet(int i){
		this.steps = i;
	}
	
	public int getBetValue(){
=======
	private static Bet steps;
	
	public Bet(Bet i){
		Bet.steps = i;
	}
	
	public static Bet getBetValue(){
>>>>>>> 9f2bd1c45dd452ddb4e981dda256868b22d4a68a
		return steps;
	}
	
}