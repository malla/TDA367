
package cha.domain;
import java.awt.Color;

import java.util.Random;

public class Board{
	
	
	private Piece pieceOne;
	private Piece pieceTwo;
	private Piece activePiece;
	private Mission mission;
	
	/**
	 * @uml.property  name="tileTypes" multiplicity="(0 -1)" dimension="1"
	 */
	Color[] tileTypes ={Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED};
	
	/**
	 * @uml.property  name="boardArray"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	Tile [] boardArray = new Tile[48];	
	
	private static Board instance;

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	public Board(){
		
		this.pieceOne = new Piece();
		this.pieceOne.setPosition(0);
		this.pieceOne.setPlayer(1);
		this.pieceTwo = new Piece();
		this.pieceTwo.setPlayer(2);
		this.pieceTwo.setPosition(0);
		this.activePiece = pieceOne;
		Random randomTiles = new Random();
		
		for(int i=0; i<48; i++){
			boardArray[i] = new Tile(tileTypes[randomTiles.nextInt(tileTypes.length)]);
		
		}
	}
	

	
	public Piece getActivePiece(){
		return activePiece;
	}
	
	public Tile getTile(int place){
		if(place < 0 || place > 48){
			throw new IllegalArgumentException();
		}
		
		else {   
			return boardArray[place];
		}		
	}
	
	public Mission getMission(){
		return mission;
	}
	
	public void startMission(){
		mission = new Mission(new Team("Team 1"));
		mission.startMission(Categories.Category.BODYTOBODY);
	}
	
}
