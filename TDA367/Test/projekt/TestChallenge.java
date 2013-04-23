package projekt;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import cha.domain.Board;
import cha.domain.Challenge;
import cha.domain.Mission;
import cha.domain.Piece;

public class TestChallenge {

	private static Piece ap;
	private static Piece op;
	private static Challenge c;

	@Before
	public void setUp() {
		Board.setTeamName("1");
		Board.setTeamName("2");
		Board.createNewBoard(2);

		ap = Board.getInstance().getPiece(0);
		op = Board.getInstance().getPiece(1);
		op.setPosition(10);
		ap.setPosition(10);
		c = new Challenge(ap, op, Categories.Category.BACKWARDS);
	}
	
	@Test
	public void testStartChallenge() {
		c.startChallenge();
		Mission m = Challenge.getMission();
		assertTrue(m != null);
		c.setScore(4);
		c.startChallenge();
		assertTrue(Challenge.getMission() != null && Challenge.getMission() != m);
	}

	@Test
	public void testSetScore() {
		c.setScore(5);
		assertTrue(c.chaScore == 5);
		c.setScore(4);
		assertTrue(c.oppScore == 4 && c.chaScore == 5);
	}
	
	@Test
	public void testGetResultApWin(){
		int apPos = ap.getPosition();
		int opPos = op.getPosition();
		c.setScore(3);
		c.setScore(1);
		assertTrue(ap.getPosition() == apPos + 3);
		assertTrue(op.getPosition() == opPos - 2);
	}
	
	@Test
	public void testGetResultOpWin(){
		int apPos = ap.getPosition();
		int opPos = op.getPosition();
		c = new Challenge(ap,op,Categories.Category.BACKWARDS);		
		apPos = ap.getPosition();
		opPos = op.getPosition();
		c.setScore(1);
		c.setScore(3);
		assertTrue(ap.getPosition() == apPos - 2);
		assertTrue(op.getPosition() == opPos + 3);
	}
	
	@Test
	public void testGetResultDraw(){
		int apPos = ap.getPosition();
		int opPos = op.getPosition();
		
		c = new Challenge(ap,op,Categories.Category.BACKWARDS);		
		apPos = ap.getPosition();
		opPos = op.getPosition();
		c.setScore(3);
		c.setScore(3);
		assertTrue(ap.getPosition() == apPos - 2);
		assertTrue(op.getPosition() == opPos + 3);
	}

}
