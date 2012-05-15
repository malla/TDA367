package cha.domain;
import java.util.Arrays;
import java.util.Random;

public class Card {
	
	private String [] assignment;
	
	public Card(String[] s){
		assignment= s;
	}

	public int randomNumber(int i){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(i);
	}

	@Override
	public String toString() {
		String asString = Arrays.toString(assignment); 
		return "Card [a1=" + asString + "]";
	}
	
	public String[] getString(){
		return assignment;
	}
}
