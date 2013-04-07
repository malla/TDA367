
package cha.domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class Board {

	private static final int MIN_TILES = 0;
	private static final int MAX_TILES = 43;
	private static Piece[] pieces;
	public int numberOfPieces = 0;
	private static ArrayList<String> teamNames = new ArrayList<String>();
	private int activePiece;
	private Turn turn;
	private final Color[] pieceColorList = new Color[] { Color.WHITE,
			Color.GREEN, Color.YELLOW, Color.BLACK, Color.RED, Color.BLUE,
			Color.ORANGE, Color.CYAN };
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	private ArrayList<Color> availableColorList = new ArrayList<Color>();
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	private Random random = new Random();
	private static Board instance = null;
	private boolean isNewGame;

	// Singleton-pattern
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}

	public static void createNewBoard(int numPiece ) {
		System.out.println("1");
		Board board = Board.getInstance();
		System.out.println("2");
		board.init(numPiece);
		System.out.println("3");
		EventBus.getInstance().publish(Event.CreateBoard, Board.getInstance().getTileList(), null);
		System.out.println("4");
		board.newTurn();
	}

	// Constructor
	private Board() {
		this.categoryList.add(Category.SAMECLASS);
		this.categoryList.add(Category.BODYTOBODY);
		this.categoryList.add(Category.WORDJUMBLE);
		this.categoryList.add(Category.BACKWARDS);
	}

	private void init(int numPiece) {
		isNewGame=true;
		tileList.clear();		// Add a new set of tiles
		for (int i = 0; i < 43; i++) {
			if (i % 5 == 0 && i != 0) {
				tileList.add(new Tile(categoryList.get(random
						.nextInt(categoryList.size())), true));
			} else
				tileList.add(new Tile(categoryList.get(random
						.nextInt(categoryList.size())), false));
		}

		// Init number of pieces
		numberOfPieces = numPiece;

		// Add new set of colors
		availableColorList.clear();
		for (Color color : pieceColorList) {
			availableColorList.add(color);
		}

		// Generate teams
		pieces = new Piece[numPiece];
		for (int i = 0; i < numPiece; i++) {
			String teamName = getTeamName(i);
			Color teamColor = availableColorList.remove(random
					.nextInt(availableColorList.size()));
			Team team = new Team(teamName, teamColor);
			pieces[i] = new Piece(team, i);
		}
		activePiece = 0;
	}

	// Methods

	public int getNumberOfPieces() {
		if (pieces == null) {
			throw new BoardNotInitializedException();
		}
		return numberOfPieces;
	}

	public Piece getActivePiece() {
		if (turn == null) 
			throw new BoardNotInitializedException();
		return this.turn.getPiece();
	}

	// Kallas bara när nytt spel initieras.
	public void setActivePiece(int activePiece) {
		this.activePiece = activePiece;

	}

	public Piece getPiece(int index) {
		if (pieces == null) {
			throw new BoardNotInitializedException();
		} else if (index < 0 || index >= pieces.length) {
			throw new IllegalArgumentException(
			"activePiece must be in the legal range");
		}
		return pieces[index];
	}

	public int getActivePieceNumber() {
		return activePiece;
	}
	
	public void newTurn(){
		System.out.println("nu skapas en ny tur");
		if(!isNewGame)
		changeActivePiece();
		isNewGame=false;
		turn= new Turn(pieces[activePiece]);
		EventBus.getInstance().publish(Event.NewTurn, null, null);
		turn.determinType();
	}

	private void changeActivePiece() {
		System.out.println("Board: Team before:" + (activePiece + 1));
		if (pieces == null) {
			throw new BoardNotInitializedException();
		}
		activePiece = activePiece + 1;
		if (activePiece == (pieces.length)) {
			activePiece = 0;
		}
		System.out.println("Board: Team after:" + (activePiece + 1));
		EventBus.getInstance().publish(Event.NextPlayer, null, null);
	}

	public Tile getTile(int place) {
		if (place < MIN_TILES || place > MAX_TILES) {
			throw new IllegalArgumentException();
		} else {
			return tileList.get(place);
		}
	}

	public ArrayList<Tile> getTileList() {
		return tileList;
	}

	public String getTeamName(int teamNumber) {
		return teamNames.get(teamNumber);
	}

	public static void setTeamName(String teamName) {
		teamNames.add(teamName);
	}

	public static void clearBoard() {
		instance = null;
	}

	public void stopMission(){
		turn.getTurnType().missionDone();
	}
	public void missionStatus(boolean b){
		turn.finishTurn(b);
	}
	
	public void initNormalTurn(){
		turn.setTurnType();
	}
	
	public Turn getTurn(){
		return turn;
	}
	
}
