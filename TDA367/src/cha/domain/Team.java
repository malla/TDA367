package cha.domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;	
	private Color color;

	private final static Color[] colors = new Color[]{
		Color.red, Color.blue, Color.green, Color.magenta, 
		Color.pink, Color.yellow, Color.orange, Color.cyan 
	};
	private static List<Color> availableColors = new ArrayList<Color>();	

	// Constructor
	
	public Team(String name, Color color) {
		this.name = name;
//		if (availableColors.isEmpty()){
//			for (Color localColor : colors)
//				availableColors.add(localColor);
//		}
//		if (!availableColors.contains(color)){
//			throw new IllegalArgumentException();
//		}
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
	
	// Static

	public static List<Color> getAvailableColors() {
		return availableColors;
	}
	
}
