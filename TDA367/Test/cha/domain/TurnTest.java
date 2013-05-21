package cha.domain;

import static org.junit.Assert.*;
import cha.event.Event;
import cha.event.IEventHandler;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;


/**Tests the Turn class
 * @author Malla
 *Not sure how to test DeterminType or StartMission
 */
public class TurnTest implements IEventHandler{
	Team team;
	Piece p;
	Turn t;
	boolean isChallenge;
	boolean makeBet;

	@Before
	public void setUp() {
		Board.clearBoard();
		Board.getInstance().setTeamName("1");
		Board.getInstance().setTeamName("2");
		Board.createNewBoard(2);
		team=new Team("TestTeam", Color.BLUE);
		p=new Piece(team, 0);
		t=new Turn(p);
		isChallenge=false;
		makeBet=false;
	}


	@Test
	public void testGetPiece() {
		Piece p2=t.getPiece();
		assertTrue(p2.equals(p));

	}

	@Test
	public void testStartMission() {
		//testHow?
	}

	@Test
	public void testDeterminType() {
		t.getPiece().setPosition(3);
		t.determinType();
//		assertTrue(isChallenge==false);
//		assertTrue(makeBet==true);
	}

	/**Tests
	 * setTurnType()
	 * getSteps()
	 * getTurnType()
	 */
	@Test
	public void testSetTurnType() {
		int steps=t.getSteps();
		assertTrue(steps == 0);
		t.setTempBet(4);
		t.setTurnType();
		steps=t.getSteps();
		assertTrue(steps == 4);
		assertTrue(t.getTurnType() instanceof NormalTurn);
	}
	
	/**Tests
	 * setTempBet()
	 * getBet()
	 */
	@Test
	public void testSetTempBet() { 
		t.setTempBet(7);
		int tb=t.getBet();
		assertTrue(tb == 7);
		t.setTempBet(4);
		tb=t.getBet();
		assertTrue(tb == 4);
	}

	/**Tests
	 * setTempOpp()
	 * getTempOpp()
	 */
	@Test
	public void testSetTempOpp() {
		String comp="Motståndare 1";
		t.setTempOpp(comp);
		String opp=t.getTempOpp();
		assertTrue(opp.equals(comp));
	}
	
	/**Tests
	 * finishTurn()
	 * isTurnOver()
	 */
	@Test
	public void testFinishTurn() {
		assertTrue(t.isTurnOver()==false);
		t.finishTurn(true);
		assertTrue(t.isTurnOver()==true);
	}


	@Override
	public void action(Event e, Object o, Object p) {
		
		if (e == Event.IsChallenge) {
			System.out.println("CHallenge");
			isChallenge=true;
		}
		if (e == Event.MakeBet) {
			System.out.println("MakeBet");

			makeBet=true;
		}
	}
}
