
package projekt;
import java.util.Random;

public class Board {
	String [] tiletypes ={ "WordMagic", "BodyToBody","SpeakBackwards", "SameClass"};

	public Board(){
		Random randomTiles = new Random();
		
		Tile t1 = new Tile(tiletypes[randomTiles.nextInt(tiletypes.length)]);
		System.out.println(t1);
	}
	
}
