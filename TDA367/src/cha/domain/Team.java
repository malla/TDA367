package cha.domain;

import java.awt.Color;

public class Team {

	private String name;	
	private Color color;
	
	// Constructor
	
	public Team(String name, Color color) {
		this.name = name;
		this.color = color;
	}
	
	// Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
