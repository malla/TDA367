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
<<<<<<< HEAD
=======
	private static final Team Team = null;

	@Test
	public void testMission() {
		Piece p = new Piece(Team);
		Bet b = new Bet(4);
		Board bd = new Board();
		Mission m = new Mission(p);
		m.startMission( Category.BODYTOBODY, b);
	}
>>>>>>> 68a357fe64aa0a1fdc56a10eb0853a5ced3fe321
	
}
