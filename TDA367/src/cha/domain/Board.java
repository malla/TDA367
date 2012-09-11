package cha.domain;

import java.awt.Color;

import java.util.ArrayList;
import java.util.Random;

import cha.domain.Categories.Category;

public class Board {

	private static final int MIN_TILES = 0;
	private static final int MAX_TILES = 48;
	/**
	 * Array with all pieces.
	 */
	private static Piece[] pieces;
	public int numberOfPieces = 0;
	private static ArrayList<String> teamNames = new ArrayList<String>();

	/**
	 * Index of the active piece.
	 */
	private int activePiece;

	/**
	 * The current mission
	 */
	private Mission currentMission;
	// public static boolean isChallenge;

	private final Color[] pieceColorList = new Color[] { Color.WHITE,
			Color.GREEN, Color.YELLOW, Color.BLACK, Color.RED, Color.BLUE,
			Color.ORANGE, Color.CYAN };

	private ArrayList<Category> categoryList = new ArrayList<Category>();
	private ArrayList<Color> availableColorList = new ArrayList<Color>();
	private ArrayList<Tile> tileList = new ArrayList<Tile>();

	private Random random = new Random();

	private static Board instance = null;

	// Singleton-pattern

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}

	public static void createNewBoard(int numPiece) {
		Board board = Board.getInstance();
		board.init(numPiece);
	}

	// Constructor
	private Board() {

		this.categoryList.add(Category.SAMECLASS);
		this.categoryList.add(Category.BODYTOBODY);
		this.categoryList.add(Category.WORDJUMBLE);
		this.categoryList.add(Category.BACKWARDS);
	}

	public void init(int numPiece) {

		// Add a new set of tiles
		tileList.clear();
		// setChallenge(false);
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
		currentMission = null;
	}

	// Methods

	public int getNumberOfPieces() {
		if (pieces == null) {
			throw new BoardNotInitializedException();
		}
		return numberOfPieces;
	}

	public Piece getActivePiece() {
		return getPiece(activePiece);
	}

	// Kallas bara n�r nytt spel initieras.
	public void setActivePiece(int activePiece) {
		if (activePiece < 0 || activePiece >= pieces.length)
			throw new IllegalArgumentException(
					"activePiece must be in the legal range");
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

	public void changeActivePiece() {
		System.out.println("Board: Team before:" + (activePiece + 1));
		if (pieces == null) {
			throw new BoardNotInitializedException();
		}
		activePiece = activePiece + 1;
		if (activePiece == (pieces.length)) {
			activePiece = 0;
		}
		System.out.println("Board: Team after:" + (activePiece + 1));

	}

	public boolean isTimeForChallenge() {
		return (Board.getInstance().getTile(
				Board.getInstance().getActivePiece().getPosition())
				.isChallenge());
	}

	public Tile getTile(int place) {
		if (place < MIN_TILES || place > MAX_TILES) {
			throw new IllegalArgumentException();
		} else {
			return tileList.get(place);
		}
	}

	public Mission getMission() {
		if (Challenge.isChallengeActive() == true) {
			return Challenge.getMission();
		} else
			return currentMission;
	}

	public void startMission() {
		if (pieces == null) {
			throw new BoardNotInitializedException();
		} else
			(currentMission = new Mission(getActivePiece(), getTile(
					getActivePiece().getPosition()).getCategory()))
					.startMission();
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

	public void startChallenge(Piece inputOppTeam) {
		System.out.println("Board: startChallenge har kallats");
		new Challenge(Board.getInstance().getActivePiece(), inputOppTeam,
				getTile(getActivePiece().getPosition()).getCategory());
	}

	public static void clearBoard() {
		instance = null;
	}
}