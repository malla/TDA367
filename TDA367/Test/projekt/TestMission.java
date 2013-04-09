package projekt;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import cha.domain.Categories.Category;
import cha.domain.Mission;
import cha.domain.Piece;
import cha.domain.Team;

public class TestMission {

	private final Team Team = null;
	private Piece p;
	private Mission m;

	@Before
	public void setUp() {
		p = new Piece(Team, 1);
		m = new Mission(p, Category.SAMECLASS);
		m.startMission();
	}

	@Test
	public void testMission() {
		int dequeSize = m.getDequeSize();
		assertTrue(dequeSize == 3);
		for (int j = 0; j < dequeSize; j++) {
			m.nextCurrentCard();
		}
		dequeSize = m.getDequeSize();
		assertTrue(dequeSize == 0);
	}


}
