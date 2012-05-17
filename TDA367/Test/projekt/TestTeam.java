package projekt;

import java.awt.Color;
import cha.domain.Team;
import static org.junit.Assert.*;

public class TestTeam {
	public void testTeam(){
		
		Team team = new Team("team1", Color.red);
		
		assertTrue(team.getName().equals("team1"));
		assertTrue(team.getColor().equals(Color.red));

	}
}
