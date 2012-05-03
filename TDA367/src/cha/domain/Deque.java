
package cha.domain;
import cha.domain.Categories.Category;
import java.util.List;

import java.util.ArrayList;

public class Deque{
	
	public ArrayList<Card> cards = new ArrayList<Card>();

	static String [] words = {"fotboll", "gorilla", "paraply", "balkong", "garderob", "isbjörn", "professor", "toalett", "armband", "prinsessa"};
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};
	static String[] bodyParts = {"Panna", "Axel", "Knä", "Hand", "Rumpa", "Armbåge", "Fot", "Mage", "Haka", "Vad", "Lår"};
	static String[][] categories = {{"Vilka är sporter utan boll?", "segling", "judo", "fotboll", "längdhopp", "hästpolo", "brännboll", "rodd", "basket", "golf", "höjdhopp", "tennis", "badminton", "rally", "speedway"},
		{"Vilka är aktiva sexIT medlemmar?", "rawa", "fridén", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke",}};

	static List<Card> getCard(Category c, Bet actualBet){
		if (c==Category.BODYTOBODY)
			Card.bodyToBody();
		else if (c==Category.BACKWARDS)
			backwards();
		else if (c==Category.SAMECLASS)
			sameClass();
		else if (c==Category.WORDJUMBLE)
			wordJumble();

		List<Card> cards = new ArrayList<Card>();
		for (int j=1; j==i; j++){
			Card card1 = new Card(c, actualBet);
			cards.add(card1);
		}
		return cards;
	}
	

}

