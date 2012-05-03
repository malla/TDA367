package cha.domain;

import java.awt.Color;

import cha.domain.Categories.Category;

public class Tile {
	
	/**
	 * @uml.property  name="type"
	 */
	Category type;
	public Tile(Category c){
		this.type = c;
	}
	
//	public String getType(){
//		return type;
//	}
	
	public Category getCategory(){
		return type;
	}
	
}
