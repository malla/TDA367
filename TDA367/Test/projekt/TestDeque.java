package projekt;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import cha.domain.Card;
import cha.domain.Categories.Category;
import cha.domain.Deque;

public class TestDeque {

	@Test
	public void testGetCardsBACKWARDS() {
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

