
package projekt;
import java.awt.Color;

import java.util.Random;

public class Board{
	private Piece pieceOne;
	private Piece pieceTwo;
	
	/**
	 * @uml.property  name="tileTypes" multiplicity="(0 -1)" dimension="1"
	 */
	Color[] tileTypes ={Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED};
	
	/**
	 * @uml.property  name="boardArray"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	Tile [] boardArray = new Tile[48];	
	Piece[][] piecePositions = new Piece[2][boardArray.length];
	
	public Board(){
		this.pieceOne = new Piece();
		this.piecePositions[0][0] = pieceOne;
		this.pieceTwo = new Piece();
		this.piecePositions[1][0] = pieceTwo;
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
