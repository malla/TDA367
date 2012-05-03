package cha.domain;

import java.awt.Color;

public class Tile {
	
	/**
	 * @uml.property  name="type"
	 */
	Enum type;
	public Tile(Enum enum1){
		this.type = enum1;
	}
	
//	public String getType(){
//		return type;
//	}
	
	public Enum getCategory(){
		return type;
	}
	
}
