package cha.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**Tests Tile
 * @author Malla
 *
 */
public class TileTest {
	Tile t;
	Tile tChallenge;

	@Before
	public void setUp() throws Exception {
		t=new Tile(Category.BACKWARDS,false);
		tChallenge=new Tile(Category.BODYTOBODY,true);

	}

	@Test
	public void testGetCategory() {
		Category c1=t.getCategory();
		Category c2=tChallenge.getCategory();
		assertTrue(c1.equals(Category.BACKWARDS));
		assertTrue(c2.equals(Category.BODYTOBODY));
	}

	@Test
	public void testIsChallenge() {
		assert(t.isChallenge()==false);
		assert(tChallenge.isChallenge()==true);

	}
}
