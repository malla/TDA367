<<<<<<< HEAD:TDA367/src/cha/domain/Deque.java
package cha.domain;
import java.util.Random;
/*
import org.apache.commons.lang.ArrayUtils;
=======
package projekt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * 
 * @author Malla
 *
 * @param <C>
 */
>>>>>>> b7c5e292811c723789ed3d5c375bffedfa779f2f:TDA367/src/projekt/Deque.java



public class Deque {
	public String s;
	public String s1;
	public String s2;
	String [] words = {"fotboll", };
	String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};
	String[] bodyParts = {"Panna", "Axel", "Knä", "Hand", "Rumpa", "Armbåge", "Fot", "Mage", "Haka", "Vad", "Lår"};
	String[][] categories = {{"Vilka är sporter utan boll?", "segling", "judo", "fotboll", "längdhopp", "hästpolo", "brännboll", "rodd", "basket", "golf", "höjdhopp", "tennis", "badminton", "rally", "speedway"},
					{"Vilka är aktiva sexIT medlemmar?", "rawa", "fridén", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke",}};
	
	public static void cardMixed(){
		s= words[randomNumber(words.length)];
		s2=s; // The 
		while (s.length()<12){
			s= s+alphabet[randomNumber(alphabet.length)];
		}
		StringBuilder jumbled = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int i=0; i<s.length(); i++)
			oldChars.add(new Character(s.charAt(i)));
		while(!oldChars.isEmpty())
		{
				int index = randomNumber(oldChars.size());
				jumbled.append(oldChars.get(index));
				oldChars.remove(index);
		}
		s1=jumbled.toString();
	}

	public void cardBackwards(){
		s= words[randomNumber(words.length)];
		s2=s; // The answer of the word.
		StringBuilder backwards = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int i=0; i<s.length(); i++)
			oldChars.add(new Character(s.charAt(i)));
		Collections.reverse(oldChars);
		for (Character c : oldChars){
			backwards.append(c);
		}
		s1 = backwards.toString();
	}
	public void cardBody(){
		s= bodyParts[randomNumber(bodyParts.length)];
		s1= bodyParts[randomNumber(bodyParts.length)];
		s2= s + " mot " + s1;
	}
	
	public void cardSameCategory() {
		int i = randomNumber(categories.length);
		s=categories[i][2]+"\n"+categories[i][3]+"\n"+categories[i][4]+"\n"+categories[i][5]+"\n"+categories[i][6]+"\n"+categories[i][7]
		  +"\n"+categories[i][8]+"\n"+categories[i][9]+"\n"+categories[i][10]+"\n"+categories[i][11]+"\n"+categories[i][12]+"\n"+categories[i][13]+"\n"+categories[i][14]+"\n"+categories[i][15];
		s1 =categories[i][1];
	}

	public int randomNumber(int i){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(i);
		}

}
*/
