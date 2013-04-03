package projekt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
	
	@RunWith(Suite.class)
	@SuiteClasses({TestBet.class, TestBoard.class, TestCard.class, TestChallenge.class,
		TestDeque.class, TestMission.class, TestPiece.class, TestTeam.class, TestTile.class})
	public class TestSuiteRunner {}
