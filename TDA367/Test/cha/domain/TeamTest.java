package cha.domain;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**Tests Team
 * @author Malla
 *
 */
public class TeamTest {
	private Team t;

	@Before
	public void setUp() throws Exception {
		t=new Team("Team1", Color.RED);
	}

	@Test
	public void testGetName() {
		assertTrue(t.getName().equals("Team1"));

	}

	@Test
	public void testGetColor() {
		assertTrue(t.getColor().equals(Color.RED));

	}

	@Test
	public void testSetColor() {
		t.setColor(Color.BLUE);
		assertTrue(t.getColor().equals(Color.BLUE));

	}

}
