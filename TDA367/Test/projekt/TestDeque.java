package projekt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cha.domain.Bet;
import cha.domain.Card;
import cha.domain.Categories.Category;
import cha.domain.Deque;

public class TestDeque {

	@Test
	public void testGetCards() {
		Deque deque = new Deque();
		    List<Card> cards = deque.getCards(Category.BODYTOBODY, 4);
            assertTrue(cards.size()==4);
		    Card card1=cards.get(0);
		    System.out.println(card1);
		    
		
	}

}
