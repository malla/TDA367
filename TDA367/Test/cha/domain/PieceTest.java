package cha.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//DONE
/**Tests Piece
 * @author Malla
 *
 */
public class PieceTest {
	Piece p;
	Piece p1;
	Piece p2;
	
	@Before
	public void setUp() throws Exception {
		Board.getInstance().setTeamName("0");
		Board.getInstance().setTeamName("1");
		Board.getInstance().setTeamName("2");
		Board.createNewBoard(3);

		p = Board.getInstance().getPiece(0);
		p1 = Board.getInstance().getPiece(1);
		p2 = Board.getInstance().getPiece(2);

	}

	@Test
	public void testMovePieceForward() {
		p.setPosition(10);
		p.movePieceForward(5);
		assertTrue(p.getPosition()==15);
	    try{
			p.setPosition(10);
			p.movePieceForward(-5);
	    }catch(Exception IllegalArgumentException) {
	      assertTrue(true);
	    }
	    p.setPosition(42);
	    p.movePieceForward(6);
	    assertTrue(p.getPosition() == 43);
	}

	@Test
	public void testMovePieceBackward() {
		p.setPosition(10);
		p.movePieceBackward();
		assertTrue(p.getPosition()==8);
		p.movePieceBackward();
		assertTrue(p.getPosition()==6);
	}

	@Test
	public void testGetTeam() {
		String t=p.getTeam().getName();
		String tComp=Board.getInstance().getTeamName(0);
		assertTrue(t.equals(tComp));
		
		t=p1.getTeam().getName();
		tComp=Board.getInstance().getTeamName(1);
		assertTrue(t.equals(tComp));
		
		t=p2.getTeam().getName();
		tComp=Board.getInstance().getTeamName(2);
		assertTrue(t.equals(tComp));
	}

	@Test
	public void testGetIndex() {
		assertTrue(p.getIndex()==0);
		assertTrue(p1.getIndex()==1);
		assertTrue(p2.getIndex()==2);
	}

	@Test
	public void testGetAndSetPosition() {
		assertTrue(p.getPosition()==0);
		p.setPosition(5);
		assertTrue(p.getPosition()==5);
	}

	@Test
	public void testToString() {
		assertTrue(p.toString().equals("Piece [position = 0]"));
	}
}