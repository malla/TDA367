
package cha.domain;

import cha.domain.Categories.Category;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;

public class Deque {

	public ArrayList<Card> cards = new ArrayList<Card>();

	static String[] wordsss = { "abdomen", "abducts", "abiding", "ability",
			"abolish", "aborted", "absence", "absinth", "absorbs", "absurds",
			"abusers", "abusing", "abusive", "acacias", "academy", "accents",
			"accepts", "acclaim", "accords", "account", "accused", "accuser",
			"accuses", "acetone", "achieve", "acrobat", "acronym", "acrylic",
			"actable", "actings", "diamond", "rituals", "emerald", "rainbow",
			"answers", "cooking", "laundry", "baskets", "ribbons", "balloon",
			"compute", "physics", "chemist", "biology", "college", "letters",
			"postage", "dresses", "flowers", "jackets", "lizards", "painter",
			"lockers", "duchess", "princes", "spanish", "germany", "russian",
			"italian", "english", "england", "corsica", "islands", "dessert",
			"rampage", "rodents", "peoples", "staples", "version", "windows",
			"recipes", "kitchen", "keeping", "yodeled", "yodlers", "yodling",
			"yoghurt", "letters", "sources", "started", "anxiety", "history",
			"install", "editors", "profile", "thunder", "dreamer", "leakage",
			"control", "parties", "showers", "lessons", "travels", "painful",
			"message", "parties", "slipper", "animals", "awarded", "muscles",
			"cleaner", "burners", "habitat", "product", "natural", "smoking",
			"upright", "account", "desired", "through", "achieve", "confirm",
			"amounts", "prepare", "repairs", "affairs", "voltage", "blemish",
			"fighter", "classic", "protein", "pimples", "clearer", "morning",
			"damaged", "checker", "prevent", "peeling", "feeling", "station",
			"fashion", "trusted", "graphic", "physics", "formula", "balance",
			"episode", "blurred", "collect", "screams", "females", "believe",
			"survive", "revives", "revolve", "rotates", "carries", "carried",
			"married", "brought", "volcano", "teacher", "student", "peeping",
			"fairies", "blessed", "coolers", "blazing", "printer", "dancing",
			"singing", "passing", "cooking", "fathers", "mothers", "runners",
			"playing", "flowers", "grasses", "sisters", "brother", "evolves",
			"knights", "players", "knowing", "release", "reports", "present",
			"scented", "preview" };

	static ArrayList<String> words = new ArrayList<String>(
			Arrays.asList(wordsss));

	static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "å", "ä", "ö" };
	static String[] bodyParts = { "Forehead", "Shoulder", "Knee", "Hand",
			"Bottom", "Elbow", "Foot", "Stomach", "Chin", "Nose", "Thigh" };
	static String[][] sameClasses = {
		{"Vilka gör inte datorer", 
			"Elektrolux", "Husqvarna", "IKEA", "OBH Nordica", "Babyliss", "Bang&Olufsen", "Philips", "Bosch", "Asus", "Acer", "HP", "Toshiba","dell", "LG"},
		{"Which are not official commities of the IT program at Chalmers?", 
			"postIT", "doIT", "6IT", "ruleIT", "findIT", "dITo", "bITter", "moveIT", "sexIT", "P.R.I.T.", "NollkIT", "drawIT","digIT", "styrIT"},
		{"Which are countries in Asia?", 
			"Yemen", "Indonesia", "India", "Thailand", "China", "Burma", "Korea", "Japan", "Ireland", "England", "Australia", "United States","Estonia", "Sweden"},
		{"Which are countries that start with a vocal?", 
			"England", "Ireland", "Italy", "Estonia", "United States", "Australia", "Indonesia", "India", "Thailand", "China", "Korea", "Burma","Japan", "Vietnam"},
		{"Which are countries in Europe?", 
			"Sweden", "Spain", "England", "France", "Italy", "Norway", "Estonia", "Portugal", "United States", "Mexico", "New Zeeland", "Chile","Yemen", "Canada"},
		{"Which do not have to be a relative?", 
			"girl", "person", "friend", "collaegue", "boss", "celebrity", "doctor", "friend", "mother", "sister", "niece", "aunt","ancestor", "relative"},
		{"Which can be used as a vessel to transport a person?", 
			"a plane", "zepelin", "helicopter", "a car", "a ferry", "a truck", "a metro", "a caravan", "a station", "a wheel", "a brake","a platform", "an engine", "a stop sign"},
		{"Which might you logically look to see in the sky?", 
			"the sun", "a bird", "the moon", "a plane", "a baloon", "stars", "zepelin", "helicopter", "flowers", "the earth", "a dog", "hearts","circles", "a car"},
		{"Which are commonly used to communicate?", 
			"telephone", "computor", "blinkers", "letters", "signs", "talking", "emails", "gestures", "mixer", "clothes", "self-reminder notes", "sink","running", "tables"},
		{"Which are typically black and white?", 
			"Zebra", "Skunk", "Dalmatian Dog", "Panda", "Magpie", "Bar Code", "Chess Board", "Oreos", "Black Mambo", "Panther", "Cobra", "Scorpion","Black Bird", "Elepfant"},
		{"Which are sports without a ball?",
			"Sailing", "Racing", "Biking", "High Jump", "Judo", "Long Jump", "Rowing", "Swimming", 
			"Cricket", "Basket", "Golf", "Tennis", "Badminton", "Football"},
		{"Which are mamals?",
			"Dolphin", "African Elephant", "Blue Whale", "Seal", "Horse", "Cow", "Polar Bear", "Rhinoserous", 
			"Penguin", "Ostrich", "Crocodile", "Tortoise","Black Bird", "Salmon"},
		{"Which animals spend a lot of time in water?", 
			"Dolphin", "Blue Whale", "Seal", "Polar Bear", "Penguin", "Crocodile", "Tortoise", "Salmon", 
			"Lion", "Horse", "Cow", "Rhinoserous","Ostrich", "Black Bird"},
		{"Which have a colour in their name?", 
			"Red Robin", "Great White Shark", "Blue Whale", "Black Mambo", "Goldfish", "Black Bird", "Red Fox", 
			"Bottle Dolphin", "Polar Bear", "African Elephant", "Kangaroo", "Salmon","Crocodile", "Tse Tse Fly"},
		{"Who are active members of sexit?", 
			"rawa", "bella", "malla", "sasse", "anno", "krobbe", "henkit", "wiiw", "brook", "e", "kara", "jocke","pewhl", "fridén"},
		{ "Which are sports?", 
				"Football", "Tennis", "Icehockey","Basketball", "Swimming", "Golf", "Badminton", "Running",
				"Photography", "Writing", "Drawing", "Reading", "Sleeping","Loving" },
		{ "Which things are sweet?", "Honey", "Sugar", "Cupcake",
				"CocaCola", "Sweet", "Lollipop", "IceCream", "Chocolate",
				"Meat", "Fish", "Pasta", "Chili", "Rice", "Salt" },
		{ "Which names are male?", "Per", "Ola", "Bert", "Oliver",
				"Nicklas", "Robin", "Dennis", "Hugo", "Sara", "Olivia",
				"Pernilla", "Hedvig", "Berit", "Signe" },
		{ "Which are kitchen appliances", "Stove", "Mixer", "Frigde",
				"Microwave", "Fryingpan", "Oven", "Pot", "Tv", "Sofa",
				"Blanket", "Remote", "Painting", "Chair" },
		{ "Which are desserts?", "Spunge cake", "Macaroon", "Icecream",
				"Tapioca pudding", "Cranberry pie",
				"Chocolate chip cookies", "Shortcake", "Apple pie",
				"Bouillabaisse", "Fish cake", "Fish and chips", "Sausage",
				"Chicken wings", "French fries" },
		{ "Which are red?", "Strawberrie", "Tomatoe", "Lady bug",
				"Ketchup", "Rose", "Lipstick", "Cranberry", "Stop sign",
				"Blueberry", "Orange", "Cucumber", "Pea", "Rice", "Leaf" },
		{ "Which are school subjects?", "Math", "English",
				"Arts and crafts", "Biology", "Science",
				"Physical education", "Geography", "History", "Football",
				"DJ:ing", "Ballet", "Twirling", "Jumping", "Sitting" },
		{ "Which are clothing stores?", "Zara", "H&M", "GinaTricot",
				"BikBok", "Solo", "Design only", "JC", "Tara", "Kappahl",
				"Ica", "Clas Ohlson", "Body shop", "Lidel", "Kicks" },
		{ "Which are drinks?", "Fanta", "CocaCola", "Cider", "Water",
				"Jucie", "Tea", "Coffe", "7up", "Concrete", "Wood",
				"Salmon", "Plastic", "Parrot", "Whale" },
		{"Which names start with the letter L?",
			"Lisa","Lennart","Love","Linnea","Linus","Loke","Liv","Ludvig","Josef","Jonna","Jens","Johan","Julius","Jimmy"}};
static ArrayList<String[]> categories = new ArrayList<String[]>(Arrays.asList(sameClasses));


	public Deque() {

	}

	public List<Card> getCards(Category c, int bet) {
		if (c == Category.BODYTOBODY) {
			return getBodyToBody(bet);
		} else if (c == Category.BACKWARDS) {
			return getBackwards(bet);
		} else if (c == Category.SAMECLASS) {
			return getSameClass();
		} else if (c == Category.WORDJUMBLE) {
			return getWordJumble(bet);
		} else {
			throw new IllegalArgumentException("unknown category");
		}
	}

	// Returns a pile of cards from Word Jumble category.
	private List<Card> getWordJumble(int i) {
		List<Card> allCards = new ArrayList<Card>();
		String word = randomWord();
		allCards.add(getJumbleCard(word, i));
		allCards.add(getJumbleCorrectCard(word));
		return allCards;
	}

	private Card getJumbleCard(String word, int bet) {
		while (word.length() < 14) {
			word = word + Deque.alphabet[randomNumber(alphabet.length)];
		}
		StringBuilder jumbled = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j = 0; j < word.length(); j++)
			oldChars.add(new Character(word.charAt(j)));
		while (!oldChars.isEmpty()) {
			int index = randomNumber(oldChars.size());
			jumbled.append(oldChars.get(index));
			oldChars.remove(index);
		}


		String[] info =new String[]{"Find a word with at least " + bet+ " letters!\n" +jumbled.toString()};

		return new Card(info);

	}

	private Card getJumbleCorrectCard(String word) {

		String[] info =new String[]{"One possible word: "+word};

		return new Card(info);
	}

	// Returns a pile of cards from Same Class category.
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
		String[] info = new String[] { (categories.get(i))[1],
				(categories.get(i))[2], (categories.get(i))[3],
				(categories.get(i))[4], (categories.get(i))[5],
				(categories.get(i))[6], (categories.get(i))[7],
				(categories.get(i))[8], (categories.get(i))[9],
				(categories.get(i))[10], (categories.get(i))[11],
				(categories.get(i))[12], (categories.get(i))[13],
				(categories.get(i))[14] };
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
		String[] info = new String[] { (categories.get(i))[0] };
		return new Card(info);
	}

	private Card getClassCorrectCard(int i) {
		String[] info = new String[] { (categories.get(i))[1],
				(categories.get(i))[2], (categories.get(i))[3],
				(categories.get(i))[4], (categories.get(i))[5],
				(categories.get(i))[6], (categories.get(i))[7],
				(categories.get(i))[8] };
		return new Card(info);
	}

	// Returns a pile of cards from Backwards category.
	private List<Card> getBackwards(int bet) {
		List<Card> allCards = new ArrayList<Card>();
		for (int j = 0; j < bet; j++) {
			String word = randomWord();
			allCards.add(getBackwardsCard(word));
			allCards.add(new Card(new String[] {"The right answer is: "+word}));
		}
		return allCards;
	}

	private Card getBackwardsCard(String word) {
		StringBuilder backwards = new StringBuilder();
		ArrayList<Character> oldChars = new ArrayList<Character>();
		for (int j = 0; j < word.length(); j++)
			oldChars.add(new Character(word.charAt(j)));
		Collections.reverse(oldChars);
		for (Character c : oldChars) {
			backwards.append(c);
		}

		String[] info =new String[]{"What is the word backwards?\n" +backwards.toString()};
		return new Card(info);
	}

	// Returns a pile of cards from Body To Body category.
	private List<Card> getBodyToBody(int bet) {
		List<Card> allCards = new ArrayList<Card>();
		for (int j = 0; j < bet; j++) {
			allCards.add(getBodyCard());
		}
		return allCards;
	}

	private Card getBodyCard() {
		String temp = bodyParts[randomNumber(bodyParts.length)];
		String temp1 = bodyParts[randomNumber(bodyParts.length)];
		String[] info = new String[] { temp + " to " + temp1 };
		// Create and add the current body parts as a card
		return new Card(info);
	}

	/*Returns a random number between 0 and the given number*/
	private int randomNumber(int i) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(i);
	}

	/* Returns a random word from ArrayList words, and then removes it from that ArrayList*/
	private String randomWord() {
		int i = randomNumber(Deque.words.size());
		String word = (String) words.get(i);
		words.remove(i);
		return word;
	}
}
