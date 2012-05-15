//fnns det et l�ttare/snabbare s�tt att f� in alla ord i en array el dyl?
//i konstruktorn, kommer jag att beh�va l�gga in en String[]???
//Kan fixa start gerjejen och kolla-�r n�gon vunnit.
//fixa currentCard och get NextCard i startmission. GJORT. Om korten �r slut - ....?
//i textpanel 
package cha.domain;
import cha.domain.Categories.Category;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;

public class Deque{

	public ArrayList<Card> cards = new ArrayList<Card>();

	static String [] wordsss = {"fotboll", "gorilla", "paraply", "balkong", "garderob", "isbj�rn", "professor", "toalett", "armband", "prinsessa"};
	static ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsss));
	static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","�","�","�"};
	static String[] bodyParts =  {"Panna", "Axel", "Kn�", "Hand", "Rumpa", "Armb�ge", "Fot", "Mage", "Haka", "Vad", "L�r"};
	static String[][] sameClasses = {{"Vilka �r sporter utan boll?", "segling", "judo", "fotboll", "l�ngdhopp", "h�stpolo", "br�nnboll", "rodd", "basket", "golf", "h�jdhopp", "tennis", "badminton", "rally", "speedway"},
		{"Vilka �r aktiva sexIT medlemmar?", "rawa", "frid�n", "bella", "brook", "malla", "sasse", "anno", "e", "krobbe", "henkit", "wiiw", "kara", "bosch","jocke"},
		{"Vilka namn b�rjar p� L?","Lisa","Lennart","Love","Linnea","Linus","Loke","Liv","Ludvig","Josef","Jonna","Jens","Johan","Julius","Jimmy"}};
	static ArrayList<String[]> categories= new ArrayList<String[]>(Arrays.asList(sameClasses));

	public Deque() {

	}

	public List<Card> getCards(Category c, int bet){
		if (c == Category.BODYTOBODY){
			return getBodyToBody(bet);
		}
		else if (c == Category.BACKWARDS){
			return getBackwards(bet);
		}
		else if (c==Category.SAMECLASS){
			return getSameClass();
		}
		else if (c==Category.WORDJUMBLE){
			return getWordJumble();
		}
		else{
			throw new IllegalArgumentException("unknown category");
		}
	}

	//Returns a pile of cards from Word Jumble category.
	private List<Card> getWordJumble() {
		List<Card> allCards = new ArrayList<Card>();
		String word = randomWord();
		allCards.add(getJumbleCard(word));
		allCards.add(getJumbleCorrectCard(word));
		return allCards;
	}
	private Card getJumbleCard(String word) {
		while (word.length()<14){
			word= word+Deque.alphabet[randomNumber(alphabet.length)];
		}
		StringBuilder jumbled = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j=0; j<word.length(); j++)
			oldChars.add(new Character(word.charAt(j)));
		while(!oldChars.isEmpty())
		{
			int index = randomNumber(oldChars.size());
			jumbled.append(oldChars.get(index));
			oldChars.remove(index);
		}
		//Deque.words.remove(i); ta bort ordet som anv�nts s� att det inte kommer igen.
		String[] info =new String[]{jumbled.toString()};
		return new Card(info);
		
	}
	private Card getJumbleCorrectCard(String word) {
		String[] info =new String[]{word};
		return new Card(info);
	}

	//Returns a pile of cards from Same Class category.
	private List<Card> getSameClass() {
		List<Card> allCards = new ArrayList<Card>();
		int i = randomNumber(categories.size());
		allCards.add(getClassMixCard(i));
		allCards.add(getClassQuestionCard(i));
		allCards.add(getClassCorrectCard(i));
		categories.remove(i);
		return allCards;
	}
	private Card getClassMixCard(int i) {
		String[] info =new String[]{(categories.get(i))[1], (categories.get(i))[2],
				(categories.get(i))[3], (categories.get(i))[4], (categories.get(i))[5],
				(categories.get(i))[6], (categories.get(i))[7], (categories.get(i))[8],
				(categories.get(i))[9], (categories.get(i))[10], (categories.get(i))[11],
				(categories.get(i))[12], (categories.get(i))[13], (categories.get(i))[14]};
		jumbleWords(info);
		return new Card(info);
	}
	private void jumbleWords(String[] A) {
		Random rand = new Random(System.currentTimeMillis());
		String temp;
		for (int i = 0; i < A.length; i++) {
			int idx = rand.nextInt(A.length);
			temp = A[idx];
			A[idx] = A[i];
			A[i] = temp;
		}
	} 
	private Card getClassQuestionCard(int i) {
		String[] info =new String[]{(categories.get(i))[0]};
		return new Card(info);
	}
	private Card getClassCorrectCard(int i) {
		String[] info =new String[]{(categories.get(i))[1], (categories.get(i))[2],
				(categories.get(i))[3], (categories.get(i))[4], (categories.get(i))[5],
				(categories.get(i))[6], (categories.get(i))[7], (categories.get(i))[8]};
		return new Card(info);
	}

	//Returns a pile of cards from Backwards category.
	private List<Card> getBackwards(int bet) {
		List<Card> allCards = new ArrayList<Card>();
		for (int j = 0; j < bet; j++){
			String word = randomWord();
			allCards.add(getBackwardsCard(word));
			allCards.add(new Card(new String[] {"word"}));
		}
		return allCards;
	}
	private Card getBackwardsCard(String word) {
		StringBuilder backwards = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j=0; j<word.length(); j++)
			oldChars.add(new Character(word.charAt(j)));
		Collections.reverse(oldChars);
		for (Character c : oldChars){
			backwards.append(c);
		}
		String[] info =new String[]{backwards.toString()};
		return new Card(info);
	}

	//Returns a pile of cards from Body To Body category.
	private List<Card> getBodyToBody(int bet) {
		List<Card> allCards = new ArrayList<Card>();
		for (int j = 0; j < bet; j++){
			allCards.add(getBodyCard());
		}
		return allCards;
	}
	private Card getBodyCard() {
		String temp= bodyParts[randomNumber(bodyParts.length)];
		String temp1= bodyParts[randomNumber(bodyParts.length)];
		String[] info =new String[]{ temp + " mot " + temp1};
		//Create and add the current body parts as a card
		return new Card(info);
	}

	private int randomNumber(int i) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(i);
	}
	private String randomWord() {
		int i=randomNumber(Deque.words.size());
		String word=(String) words.get(i);
		words.remove(i);
		return word;
	}
}
