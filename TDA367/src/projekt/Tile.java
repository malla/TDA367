package projekt;

public class Tile {
	
	/**
	 * @uml.property  name="type"
	 */
	String type;
	public Tile(String type){
		this.type = type;
	}
	
//	public String getType(){
//		return type;
//	}
	
	public String toString(){
		return type;
	}
}
