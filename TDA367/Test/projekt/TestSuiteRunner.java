package projekt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cha.domain.CardTest;
import cha.domain.DequeTest;

	
	@RunWith(Suite.class)
	@SuiteClasses({ TestBoard.class, CardTest.class, 
		cha.domain.ChallengeTest.class,cha.domain.PieceTest.class,cha.domain.TurnTest.class,
		cha.domain.MissionTest.class,cha.domain.BetTest.class,
		DequeTest.class,  TestTeam.class, TestTile.class})
	public class TestSuiteRunner {}
