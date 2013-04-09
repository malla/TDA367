package projekt;

import java.awt.Color;

import org.junit.Test;

import cha.domain.Team;
import static org.junit.Assert.*;

public class TestTeam {
	
	@Test
	public void testTeam(){
		
		Team team = new Team("team1", Color.red);
		
		assertTrue(team.getName().equals("team1"));
		assertTrue(team.getColor().equals(Color.red));

	}
}
