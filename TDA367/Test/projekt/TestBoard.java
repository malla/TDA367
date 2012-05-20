package projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import cha.domain.Board;
import cha.domain.Categories.Category;
import cha.domain.Tile;

public class TestBoard {

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
		b.init(3);
		assertTrue(b.getMission() == null && b.getActivePieceNumber() == 0 && b.getNumberOfPieces() == 3);		
	}
	

}
