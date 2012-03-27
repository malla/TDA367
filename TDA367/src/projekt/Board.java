
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
			System.out.println(boardArray[i]);
		}
	}
	
}
