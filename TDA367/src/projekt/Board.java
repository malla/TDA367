
package projekt;
import java.util.Random;

public class Board {
	String [] tileTypes ={ "WordMagic", "BodyToBody","SpeakBackwards", "SameClass"};
	Tile [] boardArray = new Tile[48];	
	
	public Board(){
		Random randomTiles = new Random();
		
		for(int i=0; i<48; i++){
			Tile t1 = new Tile(tileTypes[randomTiles.nextInt(tileTypes.length)]);
			boardArray[i] = t1;
			System.out.println(t1);
		}
	}
	
}
