package projekt;

import static org.junit.Assert.*;

import org.junit.Test;

import cha.domain.Bet;

public class TestBet {
	private int betInt = 4;
	
	@Test
	public void testBet() {
		Bet bet = new Bet(betInt);
		assertTrue(bet.getBetValue()==4);
	}

}
