
package cha.domain;
import cha.domain.Categories.Category;

public class Deque {

	static String [] words = {"fotboll", };
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};
	static String[] bodyParts = {"Panna", "Axel", "Knä", "Hand", "Rumpa", "Armbåge", "Fot", "Mage", "Haka", "Vad", "Lår"};
	static String[][] categories = {{"Vilka är sporter utan boll?", "segling", "judo", "fotboll", "längdhopp", "hästpolo", "brännboll", "rodd", "basket", "golf", "höjdhopp", "tennis", "badminton", "rally", "speedway"},
		{"Vilka är aktiva sexIT medlemmar?", "rawa", "fridén", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke",}};

	//ev ta bort den här.
	static Card getCard(Category c/*, int bet*/){
		Card card1 = new Card(c);
		return card1;
	}
}

