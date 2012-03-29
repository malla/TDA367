package cha.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cha.domain.Categories.Category;


public class Card {

	private String s;
	private String s1;
	private String s2;

	public Card(Category c){
		if (c==Category.BODYTOBODY);
		bodyToBody();
		if (c==Category.BACKWARDS);
		backwards();
		if (c==Category.SAMECLASS);
		sameClass();
		if (c==Category.WORDJUMBLE);
		wordJumble();	
	}

	public void wordJumble(){
		s= Deque.words[randomNumber(Deque.words.length)];
		s2=s; // The 
		while (s.length()<12){
			s= s+Deque.alphabet[randomNumber(Deque.alphabet.length)];
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

	public void backwards(){
		s= Deque.words[randomNumber(Deque.words.length)];
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
	public void bodyToBody(){
		s= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
		s1= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
		s2= s + " mot " + s1;
	}

	public void sameClass() {
		int i = randomNumber(Deque.categories.length);
		s=Deque.categories[i][2]+"\n"+Deque.categories[i][3]+"\n"+Deque.categories[i][4]+"\n"+Deque.categories[i][5]+"\n"+Deque.categories[i][6]+"\n"+Deque.categories[i][7]
		                                                                                                                                                                  +"\n"+Deque.categories[i][8]+"\n"+Deque.categories[i][9]+"\n"+Deque.categories[i][10]+"\n"+Deque.categories[i][11]+"\n"+Deque.categories[i][12]+"\n"+Deque.categories[i][13]+"\n"+Deque.categories[i][14]+"\n"+Deque.categories[i][15];
		s1 =Deque.categories[i][1];
	}

	public int randomNumber(int i){
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(i);
	}
}
