package cha.domain;

import java.awt.Color;
import java.util.ArrayList;

public class Team {

	private String name;
	private Color color;

	private final static Color[] availableColors = new Color[]{
		Color.red, Color.blue, Color.green, Color.magenta, 
		Color.pink, Color.yellow, Color.orange, Color.cyan 
	};
	private static ArrayList<Color> availableColorsNextRound;
	
	
	public Team(String name, Color color) {
		this.name = name;
		if (availableColorsNextRound.isEmpty()){
			for (Color localColor : availableColors)
				availableColorsNextRound.add(localColor);
		}
		
		this.color = color;
	}

}
