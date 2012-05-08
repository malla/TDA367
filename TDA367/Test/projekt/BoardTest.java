package projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import cha.domain.Board;
import cha.domain.Categories.Category;
import cha.domain.Tile;

public class BoardTest {

	@Test
	public void testGetTile() {
		Board b = Board.getInstance(3);
		Tile t = b.getTile(1);
		Tile f = b.getTile(1);
		assertTrue(t == f);
	}
	
	@Test
	public void testBoard() {
		Board b = Board.getInstance(3);
		Category c = b.getTile(1).getCategory();
		assertTrue(c != null);
	}
	

}
