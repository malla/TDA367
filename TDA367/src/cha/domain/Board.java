package cha.domain;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import cha.event.Event;
import cha.event.EventBus;

public class Board {

	public Font fontTextPanel = new Font("Comic Sans MS", Font.PLAIN, 18);
	public Font fontSmall = new Font("Comic Sans MS", Font.PLAIN, 12);
	private int numberOfPieces = 0;
	private final int MIN_TILES = 0;
	private final int MAX_TILES = 43;
	private Piece[] pieces;
	private ArrayList<String> teamNames = new ArrayList<String>();
	private int activePiece;
	private Turn turn;
	private final Color[] pieceColorList = new Color[] { Color.WHITE,
			Color.GREEN, Color.YELLOW, Color.BLACK, Color.RED, Color.BLUE,
			Color.ORANGE, Color.CYAN };
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	private ArrayList<Color> availableColorList = new ArrayList<Color>();
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	private Random random = new Random();
	private boolean isNewGame;
	
	private static Board instance = null;

	// Singleton-pattern
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}

	public static void createNewBoard(int numPiece) {
		if (numPiece <= 0) {
			throw new IllegalArgumentException();
		}
		Board board = Board.getInstance();
		board.init(numPiece);
		EventBus.getInstance().publish(Event.CreateBoard,
				Board.getInstance().getTileList(), null);
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
		isNewGame = true;
		tileList.clear(); // Add a new set of tiles
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

	public Piece getPiece(int index) {
		if (pieces == null) {
			throw new BoardNotInitializedException();
		} else if (index < 0 || index >= pieces.length) {
			throw new IllegalArgumentException(
					"activePiece must be in the legal range");
		}
		return pieces[index];
	}

	public void newTurn() {
		System.out.println("nu skapas en ny tur");
		if (!isNewGame)
			changeActivePiece();
		isNewGame = false;
		turn = new Turn(pieces[activePiece]);
		System.out.println("Board: EVENT NewTurn");
		EventBus.getInstance().publish(Event.NewTurn, null, null);
		turn.determinType();
	}

	private void changeActivePiece() {
		if (pieces == null) {
			throw new BoardNotInitializedException();
		}
		activePiece = activePiece + 1;
		if (activePiece == (pieces.length)) {
			activePiece = 0;
		}
		System.out.println("Board: EVENT NextPlayer");
		EventBus.getInstance().publish(Event.NextPlayer, null, null);
	}

	public Tile getTile(int place) {
		if (place < MIN_TILES || place > MAX_TILES) {
			throw new IllegalArgumentException();
		} else {
			return tileList.get(place);
		}
	}

	private ArrayList<Tile> getTileList() {
		return tileList;
	}

	public String getTeamName(int teamNumber) {
		return teamNames.get(teamNumber);
	}

	public void setTeamName(String teamName) {
		teamNames.add(teamName);
	}

	public static void clearBoard() {
		instance = null;
	}

	public void stopMission() {
		turn.getTurnType().missionDone();
	}

	public void missionStatus(boolean b) {
		turn.finishTurn(b);
	}

	public void initNormalTurn() {
		turn.setTurnType();
	}

	public Turn getTurn() {
		return turn;
	}

	public ArrayList<String> getAllNames() {
		return teamNames;
	}
}