package cha.domain;


public class Tile {
	
	/**
	 * @uml.property  name="type"
	 */
	private Category type;
	private boolean challenge;
	
	public Tile(Category c, boolean challenge){
		this.type = c;
		this.challenge = challenge;
	}
	
	
	public Category getCategory(){
		return type;
	}
	
	public boolean isChallenge(){
		return challenge;
	}
	
	@Override
	public String toString() {
		return type.toString();
	}
	
}
