package cha.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Tests Mission
 * @author Malla
 *Not sure how to test stopMission()
 */
public class MissionTest {
	private Category c;
	private Mission m;
	
	@Before
	public void setUp() throws Exception {
		c=Category.SAMECLASS;
		m = new Mission(c, 5);
	}


	@Test
	public void testNextCurrentCard() {
		Card card1=m.nextCurrentCard();
		Card card2=m.nextCurrentCard();
		Card card3=m.nextCurrentCard();
		assertTrue(card1!=card2);
		assertTrue(card1!=card3);
		assertTrue(card3!=card2);
	}

	@Test
	public void testStopMission() {
		//Not sure how to test.
	}

	@Test
	public void testGetCategory() {
		assertTrue(m.getCategory().equals(c));
	}

	@Test
	public void testGetTitle() {
		Mission m1=new Mission(Category.BACKWARDS,3);
		Mission m2=new Mission(Category.BODYTOBODY,3);
		Mission m3=new Mission(Category.SAMECLASS,3);
		Mission m4=new Mission(Category.WORDJUMBLE,3);
		String s=m1.getTitle();
		assertTrue(s.equals("Backwards!"));
		s=m2.getTitle();
		assertTrue(s.equals("Body to body!"));
		s=m3.getTitle();
		assertTrue(s.equals("Same category!"));
		s=m4.getTitle();
		assertTrue(s.equals("Word jumble!"));

	}

	@Test
	public void testToString() {
		assertTrue(m.toString() instanceof String);
	}

}
