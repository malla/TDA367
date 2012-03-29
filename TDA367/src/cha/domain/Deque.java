
package cha.domain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import cha.domain.Categories.Category;

public class Deque {

	static String [] words = {"fotboll", };
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};
	static String[] bodyParts = {"Panna", "Axel", "Knä", "Hand", "Rumpa", "Armbåge", "Fot", "Mage", "Haka", "Vad", "Lår"};
	static String[][] categories = {{"Vilka är sporter utan boll?", "segling", "judo", "fotboll", "längdhopp", "hästpolo", "brännboll", "rodd", "basket", "golf", "höjdhopp", "tennis", "badminton", "rally", "speedway"},
		{"Vilka är aktiva sexIT medlemmar?", "rawa", "fridén", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke",}};

	public void getCard(Category c){
		Card card1 = new Card(c);
	}
}

