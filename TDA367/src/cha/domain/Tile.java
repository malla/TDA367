package cha.domain;

import cha.domain.Categories.Category;

public class Tile {
	
	/**
	 * @uml.property  name="type"
	 */
	Category type;
	
	public Tile(Category c){
		this.type = c;
	}
	
	
	public Category getCategory( ){
		return type;
	}
	
	@Override
	public String toString() {
		return type.toString();
	}
	
}
