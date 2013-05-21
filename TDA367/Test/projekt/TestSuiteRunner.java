package projekt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

	
	@RunWith(Suite.class)
	@SuiteClasses({ TestBoard.class, TestCard.class, 
		cha.domain.ChallengeTest.class,cha.domain.PieceTest.class,cha.domain.TurnTest.class,
		cha.domain.MissionTest.class,cha.domain.BetTest.class,
		TestDeque.class,  TestTeam.class, TestTile.class})
	public class TestSuiteRunner {}
