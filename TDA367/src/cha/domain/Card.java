package cha.domain;
import java.util.Arrays;

/** Takes the given information and returns it in a Card, 
 * which contains an array of strings**/
public class Card {
	
	private String [] assignment;
	
	public Card(String[] s){
		assignment= s;
	}

	@Override
	public String toString() {
		String asString = Arrays.toString(assignment); 
		return "Card [a1=" + asString + "]";
	}
	
	/**Returns the array within the Card**/
	public String[] getString(){
		return assignment;
	}
}