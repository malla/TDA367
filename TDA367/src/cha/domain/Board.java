
package cha.domain;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

import cha.domain.Categories.Category;

public class Board{
	private Piece[] pieces;
	private Piece activePiece;
	private Mission mission;
	
	/**
	 * @uml.property  name="tileTypes" multiplicity="(0 -1)" dimension="1"
	 */
	//TODO Check if this is a proper solution
	private ArrayList<Category> categoryList = new ArrayList<Category>();

	
	/**
	 * @uml.property  name="boardArray"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	
	private ArrayList<Tile> tileList;
	

	private static Board instance;

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	// Constructors
	
	public Board(){

		this.tileList = new ArrayList<Tile>();
		this.categoryList.add(Category.SAMECLASS);
		this.categoryList.add(Category.BODYTOBODY);
		this.categoryList.add(Category.WORDJUMBLE);
		this.categoryList.add(Category.BACKWARDS);
		
		Random rand = new Random();
		for(int i=0; i<48; i++){
			tileList.add(new Tile(categoryList.get(rand.nextInt(categoryList.size()))));
		
		}
		//TODO Johan Testar
		activePiece = new Piece(new Team("Team 1",Color.BLUE));
		
	}
	
	public Board(int numPiece){
		pieces = new Piece[8];

		//TODO Johan Testar
		activePiece = new Piece(new Team("Team 1",Color.BLUE));
	}
	
	// Methods
	
	public Piece getActivePiece(){
		return activePiece;
	}
	
	public Tile getTile(int place){
		if(place < 0 || place > 48){
			throw new IllegalArgumentException();
		}
		
		else {   
			return tileList.get(place);
		}		
	}
	
	public Mission getMission(){
		return mission;
	}
	
	public void startMission(){
		mission = new Mission(new Piece(new Team("Team", Color.red)));
		mission.startMission(Categories.Category.BODYTOBODY, activePiece.getBetAmount());
	}
}
