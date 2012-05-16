package projekt;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cha.domain.Bet;
import cha.domain.Board;
import cha.domain.Categories.Category;
import cha.domain.Mission;
import cha.domain.Piece;
import cha.domain.Team;


public class TestMission {

	private static final Team Team = null;
	@Test
	public void testMission() {
		Piece p = new Piece(Team);
		Bet b = new Bet(4);
		Mission m = new Mission(p, Category.SAMECLASS);
		m.startMission();
		System.out.println(m.nextCurrentCard());
		//assertTrue(m.size()==3);
	}
	
}
