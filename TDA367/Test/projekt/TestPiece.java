package projekt;

import java.awt.Color;
import static org.junit.Assert.*;
import cha.domain.Bet;
import cha.domain.Piece;
import cha.domain.Team;

public class TestPiece {
	
	public void testPiece() {
		Bet bet = new Bet(4);
		Team team = new Team("team 1", Color.red);
		Piece piece = new Piece(team, 1);
		
		piece.setPosition(6);
		assertTrue(piece.getPosition()== 6);
		
		piece.movePieceForward(5);
		assertTrue(piece.getPosition() == 11);
		
		piece.movePieceBackward();
		assertTrue(piece.getPosition() == 9);
		
		assertTrue(piece.getBet().equals(bet));
		assertTrue(piece.getTeam().equals(team));
		
		piece.setBet(2);
		assertTrue(piece.getBet().getBetValue() == 2);
		
	}
}
