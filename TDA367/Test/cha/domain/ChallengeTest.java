package cha.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//DONE
/** Tests the Challenge class
 * @author Malla
 *
 */
public class ChallengeTest {
	Team team;
	Piece p;
	Challenge cha;
	private static Piece ap;
	private static Piece op;
	private static Challenge c;
	
	@Before
	public void setUp() throws Exception {		
		Board.getInstance().setTeamName("1");
		Board.getInstance().setTeamName("2");
		Board.createNewBoard(2);

		ap = Board.getInstance().getPiece(0);
		op = Board.getInstance().getPiece(1);
		op.setPosition(10);
		ap.setPosition(10);
		c = new Challenge(op);
	}

	/**Tests
	 * startMission()
	 */
	@Test
	public void testStartMission() {
		assertTrue(c.mission==(null));
		c.startMission(Category.BACKWARDS);
		assertTrue(c.mission!=(null));

	}

	/**Tests
	 * setScore()
	 * getChaScore()
	 * getOppScore()
	 */
	@Test
	public void testSetScore() {
		c.setScore(5);
		assertTrue(c.getChaScore() == 5);
		c.setScore(4);
		assertTrue(c.getOppScore() == 4 && c.getChaScore() == 5);
	}
	
	/**Tests
	 * opponent Piece movement if challenger wins
	 */
	@Test
	public void testGetResultApWin(){
		int opPos = op.getPosition();
		System.out.println("op="+opPos);
		c.setScore(3);
		c.setScore(1);
		System.out.println("op="+op.getPosition());
		assertTrue(op.getPosition() == opPos - 2);
	}
	
	/**Tests
	 * opponent Piece movement if opponent wins
	 */
	@Test
	public void testGetResultOppWin(){
		int opPos = op.getPosition();
		System.out.println("op="+opPos);
		c.setScore(1);
		c.setScore(2);
		System.out.println("op="+op.getPosition());
		assertTrue(op.getPosition() == opPos + 2);
	}
	
	/**Tests
	 * opponent Piece movement if draw occurs
	 */
	@Test
	public void testGetResultDraw(){
		int opPos = op.getPosition();
		System.out.println("op="+opPos);
		c.setScore(2);
		c.setScore(2);
		System.out.println("op="+op.getPosition());
		assertTrue(op.getPosition() == opPos + 2);
	}

	/**Tests
	 * getMission()
	 */
	@Test
	public void testGetMission() {
		assertTrue(c.mission==(null));
		c.startMission(Category.BACKWARDS);
		Mission m=c.getMission();
		assertTrue(m.getCategory().equals(Category.BACKWARDS));
	}
}
