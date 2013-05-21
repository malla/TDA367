package projekt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
	
	@RunWith(Suite.class)
	@SuiteClasses({TestBet.class, TestBoard.class, TestCard.class, 
		cha.domain.ChallengeTest.class,cha.domain.PieceTest.class,cha.domain.TurnTest.class,
		TestDeque.class, TestMission.class, TestTeam.class, TestTile.class})
	public class TestSuiteRunner {}
