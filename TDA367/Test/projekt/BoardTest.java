package projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import cha.domain.Board;
import cha.domain.Tile;

public class BoardTest {

	@Test
	public void testGetTile() {
		Board b = Board.getInstance();
		Tile t = b.getTile(1);
		Tile f = b.getTile(1);
		assertTrue(t == f);
	}

}
