
package projekt;
import java.util.Random;

public class Board {
	
	/**
	 * @uml.property  name="tileTypes" multiplicity="(0 -1)" dimension="1"
	 */
	String [] tileTypes ={ "WordMagic", "BodyToBody","SpeakBackwards", "SameClass"};
	/**
	 * @uml.property  name="boardArray"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	Tile [] boardArray = new Tile[48];	
	
	public Board(){
		Random randomTiles = new Random();
		
		for(int i=0; i<48; i++){
			boardArray[i] = new Tile(tileTypes[randomTiles.nextInt(tileTypes.length)]);
			
		}
	}
	
	public Tile getTile(int place){
		if(place < 0 || place > 48){
			throw new IllegalArgumentException();
		}
		
		else {
			return boardArray[place];
		}		
	}
	
}
