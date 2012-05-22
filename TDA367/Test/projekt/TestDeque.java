package projekt;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import cha.domain.Card;
import cha.domain.Categories.Category;
import cha.domain.Deque;

public class TestDeque {
	
	public String string ="abdomen abducts abiding ability abolish aborted" +
	" absence absinth absorbs absurds abusers abusing abusive acacias" +
	" academy accents accepts acclaim accords account accused accuser" +
	" accuses acetone achieve acrobat acronym acrylic actable actings" +
	" diamond rituals emerald rainbow answers cooking laundry baskets" +
	" ribbons balloon compute physics chemist biology college letters" +
	" postage dresses flowers jackets lizards painter lockers duchess" +
	" princes spanish germany russian italian english england corsica" +
	" islands dessert rampage rodents peoples staples version windows" +
	" recipes kitchen keeping yodeled yodlers yodling yoghurt letters" +
	" sources started anxiety history install editors profile thunder" +
	" dreamer leakage control parties showers lessons travels painful" +
	" message parties slipper animals awarded muscles cleaner burners" +
	" habitat product natural smoking upright account desired through" +
	" achieve confirm amounts prepare repairs affairs voltage blemish" +
	" fighter classic protein pimples clearer morning damaged checker" +
	" prevent peeling feeling station fashion trusted graphic physics" +
	" formula balance episode blurred collect screams females believe" +
	" survive revives revolve rotates carries carried married brought" +
	" volcano teacher student peeping fairies blessed coolers blazing" +
	" printer dancing singing passing cooking fathers mothers runners" +
	" playing flowers grasses sisters brother evolves knights players" +
	" knowing release reports present scented preview";

String newstring =string.replaceAll(" ", "\",\"");


	@Test
	public void testGetCardsBACKWARDS() {
		System.out.println(newstring);

		Deque deque = new Deque();
		int testedInt = 4;
		List<Card> cards = deque.getCards(Category.BACKWARDS, testedInt);
		int cardAmount = cards.size();
		assertTrue(cardAmount==(testedInt*2));
		for(int j=0;j<cardAmount;j++){
			System.out.println(cards.get(j));
		}
	}

	@Test
	public void testGetCardsBODYTOBODY() {
		Deque deque = new Deque();
		int testedInt = 4;
		List<Card> cards = deque.getCards(Category.BODYTOBODY, testedInt);
		int cardAmount = cards.size();
		assertTrue(cardAmount==testedInt);
		for(int j=0;j<cardAmount;j++){
			System.out.println(cards.get(j));
		}
	}

	@Test
	public void testGetCardsSAMECLASS() {
		Deque deque = new Deque();
		int testedInt = 4;
		List<Card> cards = deque.getCards(Category.SAMECLASS, testedInt);
		int cardAmount = cards.size();
		assertTrue(cardAmount==3);
		for(int j=0;j<cardAmount;j++){
			System.out.println(cards.get(j));
		}
	}

	@Test
	public void testGetCardsWORDJUMBLE() {
		Deque deque = new Deque();
		int testedInt = 4;
		List<Card> cards = deque.getCards(Category.WORDJUMBLE, testedInt);
		int cardAmount = cards.size();
		assertTrue(cardAmount==2);
		for(int j=0;j<cardAmount;j++){
			System.out.println(cards.get(j));
		}
	}
}

