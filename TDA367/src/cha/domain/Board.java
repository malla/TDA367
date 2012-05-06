 package cha.domain;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.domain.Categories.Category;

public class Board{
	private Piece[] pieces;
	private int activePiece;
	private Mission mission;
	
	/**
	 * @uml.property  name="tileTypes" multiplicity="(0 -1)" dimension="1"
	 */
	//TODO Check if this is a proper solution, 
	// (use integer-constants with the enum names, and use Random to randomize a Category?)
	// �r det inte det vi g�r?
	private ArrayList<Category> categoryList = new ArrayList<Category>();

	
	/**
	 * @uml.property  name="boardArray"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	

	private static Board instance = null;

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	// Constructors

	private Board(){

		this.tileList = new ArrayList<Tile>();
		this.categoryList.add(Category.SAMECLASS);
		this.categoryList.add(Category.BODYTOBODY);
		this.categoryList.add(Category.WORDJUMBLE);
		this.categoryList.add(Category.BACKWARDS);
		
		Random rand = new Random();
		for(int i=0; i<43; i++){
			tileList.add(new Tile(categoryList.get(rand.nextInt(categoryList.size()))));
		}
		ChallengeAccepted.getInstance().publish(Event.CreateBoard, tileList);
		//TODO Johan Testar
		//activePiece = new Piece(new Team("Team 1",Color.blue));
	}
	
	public Board(int numPiece){
		pieces = new Piece[8];

		//TODO Johan Testar
		//activePiece = new Piece(new Team("Team 1",
		//		Team.getAvailableColors().get(0)));
	}
	
	// Methods
	
	public Piece getActivePiece(){
		return getPiece(activePiece);
	}
	
	public void changeActivePiece(){
		if(activePiece > (pieces.length-1)){
			activePiece = 0;
		}
		else{
			activePiece = activePiece+1;
		}
		
	}
	
	public Piece getPiece(int place){
		return pieces[place];
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
		//TODO Fix Bet
		mission = new Mission(getActivePiece(), new Bet(getPiece(activePiece).getBetAmount()));
		mission.startMission((getTile(getActivePiece().getPosition())).getCategory(), Piece.getBetAmount());
	}
	
}
