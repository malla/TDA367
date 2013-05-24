package cha.domain;

import java.awt.Color;

public class Team {

	private String name;	
	private Color teamColor;
	
	// Constructor
	
	public Team(String name, Color color) {
		this.name = name;
		this.teamColor = color;
	}
	
	// Methods
	public String getName() {
		return name;
	}

	public Color getColor() {
		return teamColor;
	}

	public void setColor(Color color) {
		this.teamColor = color;
	}
	
	
}
