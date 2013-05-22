package cha.domain;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cha.domain.Board;
import cha.domain.Category;
import cha.domain.Piece;
import cha.domain.Tile;

public class BoardTest {

	@Before
	public void setUp() {
		Board.clearBoard();
		Board.getInstance().setTeamName("1");
		Board.getInstance().setTeamName("2");
		Board.createNewBoard(2);
	}

	@Test
	public void testGetTile() {
		Board b = Board.getInstance();
		Tile t = b.getTile(1);
		Tile f = b.getTile(1);
		assertTrue(t == f);
	}

	@Test
	public void testBoard() {
		Board b = Board.getInstance();
		Category c = b.getTile(1).getCategory();
		assertTrue(c != null);
	}

	@Test
	public void testInit() {
		Board b = Board.getInstance();
		b.setTeamName("3");
		Board.createNewBoard(3);
		assertTrue(b.getNumberOfPieces() == 3
				&& b.getActivePiece() == b.getTurn().getPiece());
		try {
			b.getTile(44);
			assertTrue(false);
		} catch (IllegalArgumentException e) {
			assertTrue(true);

		}

	}

	@Test
	public void testGetNumberOfPieces() {
		Board b = Board.getInstance();
		assertTrue(b.getNumberOfPieces() == 2);
	}

	@Test
	public void testGetPiece() {
		Board b = Board.getInstance();
		Piece p = b.getPiece(1);
		Piece t = b.getPiece(1);
		assertTrue(p.equals(t));
	}

	@Test
	public void testGetActivePiece() {
		Board b = Board.getInstance();
		Piece p = b.getActivePiece();
		Piece t = b.getActivePiece();
		assertTrue(p.equals(t) && p.getIndex() == 0);
	}

	@Test
	public void testNewTurn() {
		Board b = Board.getInstance();
		b.newTurn();
		assertTrue(b.getActivePiece().getIndex() == 1);
	}

	@Test
	public void testGetTeamName() {
		Board b = Board.getInstance();
		assertTrue(b.getTeamName(0).equals("1"));
	}

	@Test
	public void testSetTeamName() {
		Board b = Board.getInstance();
		b.setTeamName("3");
		Board.createNewBoard(3);
		assertTrue(b.getTeamName(2).equals("3"));
	}

	/*
	 * Not able to test since as soon as you call getInstance you create a new
	 * board
	 */
	@Test
	public void testClearBoard() {
		Board b = Board.getInstance();
		Tile oldTile = b.getTile(4);
		b.clearBoard();
		assertTrue(b.getTile(4).hashCode() != oldTile.hashCode());
	}

	@Test
	public void testStopMission() {
		Board b = Board.getInstance();

	}

	@Test
	public void testMissionStatus() {
		Board b = Board.getInstance();
		b.missionStatus(false);
		assertTrue(b.getTurn().isTurnOver() == true);
	}

	@Test
	public void testInitNormalTurn() {
		Board b = Board.getInstance();

	}

	@Test
	public void testGetTurn() {
		Board b = Board.getInstance();
		assertTrue(b.getTurn().getPiece().equals(b.getActivePiece()));

	}

	@Test
	public void testGetAllNames() {
		Board b = Board.getInstance();
		ArrayList<String> allNames = b.getAllNames();
		assertTrue(allNames.size() == 2);
	}

}
