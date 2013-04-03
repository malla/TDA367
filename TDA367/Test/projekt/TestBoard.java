package projekt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import cha.domain.Board;
import cha.domain.Categories.Category;
import cha.domain.Tile;

public class TestBoard {
	
	@Before
	public void setUp(){
		Board.clearBoard();
		Board.setTeamName("1");
		Board.setTeamName("2");
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
	public void testInit(){
		Board b = Board.getInstance();
		Board.setTeamName("3");
		Board.createNewBoard(3);
		assertTrue(b.getMission() == null && b.getActivePieceNumber() == 0 && b.getNumberOfPieces() == 3);
		assertTrue(b.getTileList().size() == 43);
		int i = 0;
		for(Tile t : b.getTileList()){
			if(i % 5 == 0 && i != 0)
				assertTrue(t.isChallenge());
			else
				assertTrue(!t.isChallenge());
			i++;
		}
	}
	
	@Test
	public void testChangeActivePiece() {
		Board b = Board.getInstance();
		assertTrue(b.getActivePieceNumber() == 0);
		b.changeActivePiece();
		assertTrue(b.getActivePieceNumber() == 1);
		b.changeActivePiece();
		assertTrue(b.getActivePieceNumber() == 0);
	}
	

}
