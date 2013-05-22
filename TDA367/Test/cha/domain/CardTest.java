package cha.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//DONE
/**Tests Card
 * @author Malla
 *
 */
public class CardTest {
	private String[] strings;
	private Card c;
	@Before
	public void setUp() throws Exception {
		strings=new String[]{"a", "b", "c", "d", "e", "f",};
		c=new Card(strings);
	}

	@Test
	public void testToString() {
		String s="Card [a1=[a, b, c, d, e, f]]";
		assertTrue(s.equals(c.toString()));	}

	@Test
	public void testGetString() {
		String[] s=c.getString();
		assertTrue(s.equals(strings));
	}

}
