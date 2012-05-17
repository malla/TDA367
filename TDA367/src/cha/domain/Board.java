 package cha.domain;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;


import cha.domain.Categories.Category;

public class Board{
	
	private static final int MIN_TILES = 0;
	private static final int MAX_TILES = 48;
	/**
	 * Array with all pieces.
	 */
	private static Piece[] pieces;
	public int numberOfPieces = 0;
	
	/**
	 * Index of the active piece.
	 */
	private int activePiece;
	
	/**
	 * The current mission
	 */
	private Mission currentMission;

	
	/**
	 * @uml.property  name="tileTypes" multiplicity="(0 -1)" dimension="1"
	 */
	// What is this?
	
	//TODO Check if this is a proper solution, 
	// (use integer-constants with the enum names, and use Random to randomize a Category?)
	// �r det inte det vi g�r?
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	private ArrayList<Color> colorList = new ArrayList<Color>();
	private ArrayList<Tile> tileList = new ArrayList<Tile>();

	private Random random = new Random();
	
	private static Board instance = null;

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	public static void createNewBoard(int numPiece){
		Board board = Board.getInstance();
		board.init(numPiece);
	}
	
	// Constructor
	
	private Board(){
		//TODO Check if proper method and if we should place it somewhere else
		this.categoryList.add(Category.SAMECLASS);
		this.categoryList.add(Category.BODYTOBODY);
		this.categoryList.add(Category.WORDJUMBLE);
		this.categoryList.add(Category.BACKWARDS);
		
		this.colorList.add(Color.WHITE);
		this.colorList.add(Color.GREEN);
		this.colorList.add(Color.YELLOW);
		this.colorList.add(Color.BLACK);
		this.colorList.add(Color.RED);
		this.colorList.add(Color.BLUE);
		this.colorList.add(Color.ORANGE);
		this.colorList.add(Color.CYAN);
	}
	
	public void init(int numPiece){
		
		// Add a new set of tiles
		for(int i=0; i<43; i++){
			tileList.add(new Tile(categoryList.get(random.nextInt(categoryList.size()))));
		}
		
		// Init number of pieces
		numberOfPieces = numPiece;

		// Generate teams
		pieces = new Piece[numPiece];
		for(int i = 0; i < numPiece; i++){
			String teamName = "Team " + i+1;
			Color teamColor = colorList.remove(
					random.nextInt(colorList.size()));
			Team team = new Team(teamName, teamColor);
			pieces[i] = new Piece(team);
		}
		activePiece = 0;
	}
	
	// Methods 
	
	public int getNumberOfPieces(){
		if (pieces == null){
			throw new BoardNotInitializedException();
		}
		return numberOfPieces;
	}
	
	public Piece getActivePiece(){
		return getPiece(activePiece);
	}

	public void setActivePiece(int activePiece) {
		if (activePiece < 0 || activePiece >= pieces.length)
			throw new IllegalArgumentException("activePiece must be in the legal range");
		this.activePiece = activePiece;
	}

	public int getActivePieceIndex() {
		return activePiece;
	}

	public Piece getPiece(int index){
		if (pieces == null){
			throw new BoardNotInitializedException();
		}
		else if (index < 0 || index >= pieces.length){
			throw new IllegalArgumentException("activePiece must be in the legal range");
		}
		return pieces[index];
	}
	
	public int getActivePieceNumber(){
		return activePiece;
	}
	
	public void changeActivePiece(){

		if (pieces == null){
			throw new BoardNotInitializedException();
		}
		
		if(activePiece == (pieces.length-1)){

			activePiece = 0;
		}
		else{
			activePiece = activePiece+1;
		}
	}
	
	public Tile getTile(int place){
		if(place < MIN_TILES || place > MAX_TILES){
			throw new IllegalArgumentException();
		}
		else {   
			return tileList.get(place);
		}		
	}
	
	public Mission getMission(){
		return currentMission;
	}

	public void startMission(){
		if (pieces == null){
			throw new BoardNotInitializedException();
		}
		(currentMission = new Mission(getActivePiece(),
				getTile(getActivePiece().getPosition()).getCategory())).startMission();
	}
	
	public ArrayList<Tile> getTileList(){
		return tileList;
		
	}
}
