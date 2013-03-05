package projekt;

import java.awt.Color;

import org.junit.Test;

import static org.junit.Assert.*;
import cha.domain.Piece;
import cha.domain.Team;

public class TestPiece {
	
	@Test
	public void testPiece() {
		Team team = new Team("team 1", Color.red);
		Piece piece = new Piece(team, 1);

		piece.setBet(4);
		
		assertTrue(piece.getBet().getBetValue() == 4);
		
		piece.setPosition(6);
		assertTrue(piece.getPosition()== 6);
		
		piece.movePieceForward(5);
		assertTrue(piece.getPosition() == 11);
		
		piece.movePieceBackward();
		assertTrue(piece.getPosition() == 9);
		
		assertTrue(piece.getBet().getBetValue() == 0);
		
		assertTrue(piece.getTeam().equals(team));
		
		piece.setBet(2);
		assertTrue(piece.getBet().getBetValue() == 2);
		
	}
}
