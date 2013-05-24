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
	private Board b; 
	
	@Before
	public void setUp() {
		Board.clearBoard();
		b = Board.getInstance();
		Board.getInstance().setTeamName("1");
		Board.getInstance().setTeamName("2");
		Board.createNewBoard(2);
	}

	@Test
	public void testGetTile() {
		Tile t = b.getTile(1);
		Tile f = b.getTile(1);
		assertTrue(t == f);
		try {
			b.getTile(-5);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCreateNewBoard() {
		try{
			Board.createNewBoard(0);
		}
		catch (IllegalArgumentException e){
			assertTrue(true);
		}
		
	}

	@Test
	public void testBoard() {
		Category c = b.getTile(1).getCategory();
		assertTrue(c != null);
	}

	@Test
	public void testInit() {
		b.setTeamName("3");
		Board.createNewBoard(3);
		assertTrue(b.getNumberOfPieces() == 3
				&& b.getActivePiece() == b.getTurn().getPiece());
		try {
			b.getTile(44);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testGetNumberOfPieces() {
		assertTrue(b.getNumberOfPieces() == 2);
	}

	@Test
	public void testGetPiece() {
		Piece p = b.getPiece(1);
		Piece t = b.getPiece(1);
		assertTrue(p.equals(t));
		try{
			b.getPiece(10);
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
		try{
			b.getPiece(-4);
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	@Test
	public void testGetActivePiece() {
		Piece p = b.getActivePiece();
		Piece t = b.getActivePiece();
		assertTrue(p.equals(t) && p.getIndex() == 0);
	}

	@Test
	public void testNewTurn() {
		b.newTurn();
		assertTrue(b.getActivePiece().getIndex() == 1);
	}

	@Test
	public void testGetTeamName() {
		assertTrue(b.getTeamName(0).equals("1"));
	}

	@Test
	public void testSetTeamName() {
		b.setTeamName("3");
		Board.createNewBoard(3);
		assertTrue(b.getTeamName(2).equals("3"));
	}

	@Test
	public void testMissionStatus() {
		b.missionStatus(false);
		assertTrue(b.getTurn().isTurnOver() == true);
	}

	@Test
	public void testGetTurn() {
		assertTrue(b.getTurn().getPiece().equals(b.getActivePiece()));

	}

	@Test
	public void testGetAllNames() {
		ArrayList<String> allNames = b.getAllNames();
		assertTrue(allNames.size() == 2);
	}

}
