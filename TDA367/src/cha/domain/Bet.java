package cha.domain;

public class Bet {

	//private static Bet steps;
	private int steps;
	
	/*public Bet(Bet i){
		this.steps = i;
	}	
	
	public static Bet getBetValue(){

		return steps;
	}*/
	
	public Bet(int steps){
		this.steps = steps;
	}
	
	public int getBetValue(){
		return steps;
	}
	
}