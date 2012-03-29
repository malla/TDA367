package cha.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cha.domain.Categories.Category;


public class Card {

	public String s;
	public String s1;
	public String s2;

	public Card(Category c){



	}
	public void cardMixed(){
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
		s= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
		s1= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
		s2= s + " mot " + s1;
	}

	public void cardSameCategory() {
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
