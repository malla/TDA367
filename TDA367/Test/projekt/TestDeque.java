package projekt;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import cha.domain.Card;
import cha.domain.Categories.Category;
import cha.domain.Deque;

public class TestDeque {

	@Test
	public void testGetCards() {
		Deque deque = new Deque();
		Category testedCategory = Category.SAMECLASS;
		List<Card> cards = deque.getCards(testedCategory, 4);
		int cardAmount = cards.size();
		if (testedCategory==Category.BACKWARDS)
			assertTrue(cardAmount==8);
		if (testedCategory==Category.BODYTOBODY)
			assertTrue(cardAmount==4);
		if (testedCategory==Category.BACKWARDS)
			assertTrue(cardAmount==8);
		if (testedCategory==Category.BACKWARDS)
			assertTrue(cardAmount==8);
		for(int j=0;j<cardAmount;j++){
			System.out.println(cards.get(j));
		}
	}

}
