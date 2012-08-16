package projekt;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cha.domain.Categories.Category;
import cha.domain.Mission;
import cha.domain.Piece;
import cha.domain.Team;


public class TestMission {

	private static final Team Team = null;
	@Test
	public void testMission() {
		Piece p = new Piece(Team, 1);
		Mission m = new Mission(p, Category.SAMECLASS);
		m.startMission();
		int dequeSize = m.dequeSize();
		assertTrue(dequeSize==3);
		for(int j=0;j<dequeSize;j++){
		System.out.println(m.nextCurrentCard());
		}
		dequeSize = m.dequeSize();
		assertTrue(dequeSize==0);
	}
	
}
