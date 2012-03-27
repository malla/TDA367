package projekt;

import java.awt.Color;

public class Tile {
	
	/**
	 * @uml.property  name="type"
	 */
	Color type;
	public Tile(Color type){
		this.type = type;
	}
	
//	public String getType(){
//		return type;
//	}
	
	public Color getColor(){
		return type;
	}
	
}
