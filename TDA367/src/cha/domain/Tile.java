package cha.domain;


public class Tile {
	
	/**
	 * @uml.property  name="type"
	 */
	private Category type;
	private boolean challenge;
	
	public Tile(Category category, boolean challenge){
		this.type = category;
		this.challenge = challenge;
	}
	
	
	public Category getCategory(){
		return type;
	}
	
	public boolean isChallenge(){
		return challenge;
	}	
}
