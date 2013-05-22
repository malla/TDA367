package cha.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	BetTest.class, 
	CardTest.class, 
	ChallengeTest.class,
	DequeTest.class,
	MissionTest.class,
	NormalTurnTest.class,
	PieceTest.class,
	TeamTest.class,
	TileTest.class,
	TurnTest.class,
	cha.domain.BoardTest.class,
})
public class TestSuiteRunner {}
