//Måste jag göra om mina arrayer till listor för tt kunna ta bort objekt på specifika index?
package cha.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cha.domain.Categories.Category;
import java.util.List;

import java.util.ArrayList;

public class Card {

	private String temp;
	private String temp1;
	private String assignment;
	private String solution;
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String a5;
	private String a6;
	private String a7;
	private String a8;
	private String a9;
	private String a10;
	private String a11;
	private String a12;
	private String a13;
	private String a14;
	private String b;

	public Card(){
		String a1=this.a1;
		String a2=this.a2;
		String a3=this.a3;
		String a4=this.a4;
		String a5=this.a5;
		String a6=this.a6;
		String a7=this.a7;
		String a8=this.a8;
		String a9=this.a9;
		String a10=this.a10;
		String a11=this.a11;
		String a12=this.a12;
		String a13=this.a13;
		String a14=this.a14;
	}
	public Card(String s1, String s2,String s3, String s4, String s5, String s6, String s7){
		String a1=s1;
		String a2=s2;
		String a3=s3;
		String a4=s4;
		String a5=s5;
		String a6=s6;
		String a7=s7;
		}

	public Card(String s){
		String a1=s;
	}

/*		public Card(Category c, Bet i){ //En konstruktor som returerar en lista med kort??
		if (c==Category.BODYTOBODY)
			bodyToBody(1);
		else if (c==Category.BACKWARDS)
			backwards();
		else if (c==Category.SAMECLASS)
			sameClass();
		else if (c==Category.WORDJUMBLE)
			wordJumble();	
	}*/

	public void wordJumble(){
		List<Card> allCards = new ArrayList<Card>();
		int i=randomNumber(Deque.words.length);
		temp= Deque.words[i];
		a2=temp; // The 
		while (temp.length()<12){
			temp= temp+Deque.alphabet[randomNumber(Deque.alphabet.length)];
		}
		StringBuilder jumbled = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j=0; j<temp.length(); j++)
			oldChars.add(new Character(temp.charAt(j)));
		while(!oldChars.isEmpty())
		{
			int index = randomNumber(oldChars.size());
			jumbled.append(oldChars.get(index));
			oldChars.remove(index);
		}
		//Deque.words.remove(i); ta bort ordet som använts så att det inte kommer igen.
		a1=jumbled.toString();
		Card card1 = new Card(a1);
		allCards.add(card1);
		Card card2 = new Card(a2);
		allCards.add(card2);
	}
	//Hur sätter jag 14 ord på smidigt sätt?
	public void backwards(){ 
		List<Card> allCards = new ArrayList<Card>();
		spellBackwards(a1, a8);
		spellBackwards(a2, a9);
		spellBackwards(a3, a10);
		spellBackwards(a4, a11);
		spellBackwards(a5, a12);
		spellBackwards(a6, a13);
		spellBackwards(a7, a14); //Ta bort! använt ord efter varje gång!!
		//Create and add card with backward string.
		Card card1 = new Card(a1, a2, a3, a4, a5, a6, a7);
		allCards.add(card1);
		Card card2 = new Card();
		allCards.add(card2);
	}
	
	private void spellBackwards(String s, String t){
		int i=randomNumber(Deque.words.length);
		t= Deque.words[i];
		StringBuilder backwards = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j=0; j<t.length(); j++)
			oldChars.add(new Character(t.charAt(j)));
		Collections.reverse(oldChars);
		for (Character c : oldChars){
			backwards.append(c);
		}
		s= backwards.toString();
	}
	
	public void bodyToBody(int i){
		List<Card> allCards = new ArrayList<Card>();
		for (int j=1; j==i; j++){
			temp= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
			temp1= Deque.bodyParts[randomNumber(Deque.bodyParts.length)];
			a1= temp + " mot " + temp1;
			//Create and add the current body parts as a card
			Card card1 = new Card(a1);
			allCards.add(card1);
		}
	}

	public void sameClass() {//Vore bra att lägga till ett tredje kort med enbart alla rätt svar.
		List<Card> allCards = new ArrayList<Card>();
		int i = randomNumber(Deque.categories.length);
		a1=Deque.categories[i][1];
		a2=Deque.categories[i][2];
		a3=Deque.categories[i][3];
		a4=Deque.categories[i][4];
		a5=Deque.categories[i][5];
		a6=Deque.categories[i][6];
		a7=Deque.categories[i][7];
		a8=Deque.categories[i][8];
		a9=Deque.categories[i][9];
		a10=Deque.categories[i][10];
		a11=Deque.categories[i][11];
		a12=Deque.categories[i][12];
		a13=Deque.categories[i][13];
		a14=Deque.categories[i][14];
		//Create and add a card with all the words
		Card card1 = new Card();
		allCards.add(card1);
		//Create second card with question
		Card card2 = new Card(Deque.categories[i][0]);
		allCards.add(card2);
		//Add 1st card again so players can see.
		allCards.add(card1);
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
