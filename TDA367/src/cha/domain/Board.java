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

	
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	private final Color[] colorList = new Color[]{
			Color.WHITE,
			Color.GREEN,
			Color.YELLOW,
			Color.BLACK,
			Color.RED,
			Color.BLUE,
			Color.ORANGE,
			Color.CYAN
	};
	private ArrayList<Color> availableColorList = new ArrayList<Color>();
	private ArrayList<Tile> tileList = new ArrayList<Tile>();

	private Random random = new Random();
	
	private static Board instance = null;

	//Singleton-pattern
	
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
		
		this.categoryList.add(Category.SAMECLASS);
		this.categoryList.add(Category.BODYTOBODY);
		this.categoryList.add(Category.WORDJUMBLE);
		this.categoryList.add(Category.BACKWARDS);
	}
	
	public void init(int numPiece){
		
		// Add a new set of tiles
		tileList.clear();
		for(int i=0; i<43; i++){
			tileList.add(new Tile(categoryList.get(random.nextInt(categoryList.size()))));
		}
		
		// Init number of pieces
		numberOfPieces = numPiece;

		// Add new set of colors
		availableColorList.clear();
		for(Color color : colorList){
			availableColorList.add(color);
		}
		
		// Generate teams
		pieces = new Piece[numPiece];
		for(int i = 0; i < numPiece; i++){
			String teamName = "Team " + (i+1);
			Color teamColor = availableColorList.remove(
					random.nextInt(availableColorList.size()));
			Team team = new Team(teamName, teamColor);
			pieces[i] = new Piece(team);
		}
		activePiece = 0;
		currentMission = null;
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
