package cha.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cha.domain.Categories.Category;


public class Card {

	private String temp;
	private String temp1;
	private String assignment;
	private String solution;

	public Card(Category c){
		if (c==Category.BODYTOBODY)
			bodyToBody();
		else if (c==Category.BACKWARDS)
			backwards();
		else if (c==Category.SAMECLASS)
			sameClass();
		else if (c==Category.WORDJUMBLE)
			wordJumble();	
		//String assignment = this.assignment;
		//String solution = this.solution;
	}
	
	public String getAssignment(){
		return assignment;
	}

	public void wordJumble(){
		temp= Deque.words[randomNumber(Deque.words.length)];
		solution=temp; // The 
		while (temp.length()<12){
			temp= temp+Deque.alphabet[randomNumber(Deque.alphabet.length)];
		}
		StringBuilder jumbled = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int i=0; i<temp.length(); i++)
			oldChars.add(new Character(temp.charAt(i)));
		while(!oldChars.isEmpty())
		{
			int index = randomNumber(oldChars.size());
			jumbled.append(oldChars.get(index));
			oldChars.remove(index);
		}
		assignment=jumbled.toString();
	}

	public void backwards(){
		temp= Deque.words[randomNumber(Deque.words.length)];
		solution=temp; // The answer of the word.
		StringBuilder backwards = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int i=0; i<temp.length(); i++)
			oldChars.add(new Character(temp.charAt(i)));
		Collections.reverse(oldChars);
		for (Character c : oldChars){
			backwards.append(c);
		}
		assignment = backwards.toString();
	}
	public void bodyToBody(){
		temp= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
		temp1= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
		assignment= temp + " mot " + temp1;
	}

	public void sameClass() {
		int i = randomNumber(Deque.categories.length);
		assignment=Deque.categories[i][2]+"\n"+Deque.categories[i][3]+"\n"+Deque.categories[i][4]+
				"\n"+Deque.categories[i][5]+"\n"+Deque.categories[i][6]+"\n"+Deque.categories[i][7]+
				"\n"+Deque.categories[i][8]+"\n"+Deque.categories[i][9]+"\n"+Deque.categories[i][10]+
		        "\n"+Deque.categories[i][11]+"\n"+Deque.categories[i][12]+"\n"+Deque.categories[i][13]+
		        "\n"+Deque.categories[i][14]+"\n"+Deque.categories[i][1];
		solution =Deque.categories[i][0];
	}

	public int randomNumber(int i){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(i);
	}

	@Override
	public String toString() {
		return "Card [assignment=" + assignment + "]";
	}
}
