package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import cha.domain.Board;
import cha.domain.Categories.Category;
import cha.domain.Piece;
import cha.domain.Tile;
import cha.event.Event;
import cha.event.EventBus;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class TileContainerPanel extends JPanel implements IEventHandler {

	private static final int MAX_AMOUNT_TILES = 44;

	private static TilePanel[] tilePanels = new TilePanel[MAX_AMOUNT_TILES];

	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	
	private ArrayList<PiecePanel> piecePanels = new ArrayList<PiecePanel>();

	// Board.getInstance().getActivePiece() ????, same as bet, USE ONLY ONE
	private int currentPiece;
	
	// TODO: Current bet already exists and is used in/from each Piece, so determine which to use, ONLY ONE!!!
	private static int currentBet;
	
	// TODO: Why is the type of betable int? Sounds like a boolean to me...
	private static int betable = 0;

	// Constructor & initilization

	public TileContainerPanel() {
		setLayout(new BorderLayout(0, 0));
		EventBus.getInstance().register(this);
		init();
	}
	
	private void init() {
		
		// Set layouts of the tile panels.
		
		eastPanel.setPreferredSize(new Dimension(50, 0));
		FlowLayout flowLayout_1 = (FlowLayout) eastPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		FlowLayout flowLayout_2 = (FlowLayout) southPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		westPanel.setPreferredSize(new Dimension(50, 0));
		FlowLayout flowLayout_3 = (FlowLayout) westPanel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		flowLayout_3.setVgap(0);
		flowLayout_3.setHgap(0);
		FlowLayout flowLayout_4 = (FlowLayout) northPanel.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		flowLayout_4.setVgap(0);
		flowLayout_4.setHgap(0);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(westPanel, BorderLayout.WEST);

	}

	// Create new game, update all GUI to match current game
	
	public void newGame(ArrayList<Tile> tiles){
		
		setTiles(tiles);
		
		int numberOfPieces = Board.getInstance().getNumberOfPieces();
		
		piecePanels.clear();
		for(int i = 0 ; i < numberOfPieces; i++){
			Piece piece = Board.getInstance().getPiece(i); 
			piecePanels.add(new PiecePanel(piece,
					piece.getTeam().getColor()));
		}
		
		for(PiecePanel piece : piecePanels){
			tilePanels[0].addPiecePanel(piece);
		}

		Board.getInstance().setActivePiece(0);
		currentPiece = 0;
		
	}
	
	// Methods
	
	private void setTiles(ArrayList<Tile> tiles) {
		northPanel.removeAll();
		eastPanel.removeAll();
		southPanel.removeAll();
		westPanel.removeAll();
		
		TilePanel start = new StartTilePanel(tiles.get(0).getCategory());
		tilePanels[0] = start;
		northPanel.add(start);
		
		TilePanel goal = new GoalTilePanel();
		tilePanels[43] = goal;
		westPanel.add(goal);
		
		for (int i = 1; i < 14; i++) {
			TilePanel p = createTile(tiles.get(i), i);
			tilePanels[i] = p;
			northPanel.add(p);
		}
		for (int i = 14; i < 22; i++) {
			TilePanel p = createTile(tiles.get(i), i);
			tilePanels[i] = p;
			eastPanel.add(p);
		}
		for (int i = 35; i > 21; i--) {
			TilePanel p = createTile(tiles.get(i), i);
			tilePanels[i] = p;
			southPanel.add(p);
		}		

		for (int i = 42; i > 35; i--) {
			TilePanel p = createTile(tiles.get(i), i);
			tilePanels[i] = p;
			westPanel.add(p);
		}
		repaint();
	}
	
	private TilePanel createTile(Tile t, int position){
		TilePanel tile;
		Category c = t.getCategory();
		if(c == Category.BACKWARDS){
			tile = new NormalTilePanel(Color.RED, position);
		}
		else if(c == Category.BODYTOBODY){
			tile = new NormalTilePanel(Color.YELLOW, position);
		}
		else if(c == Category.SAMECLASS){
			tile = new NormalTilePanel(Color.BLUE, position);
		}
		else {
			tile = new NormalTilePanel(Color.GREEN, position);
		}
		return tile;
	}
	
	private void nextPlayer(){
		Board.getInstance().changeActivePiece();
		currentPiece = Board.getInstance().getActivePieceNumber();
	}

	public static TilePanel[] getTilePanels() {
		return tilePanels;
	}
	
	@SuppressWarnings("unchecked")
	public void action(Event e, Object o) {
		if(e == Event.CreateBoard){
			ArrayList<Tile> tiles = (ArrayList<Tile>)o;
			newGame(tiles);
		}
		else if (e == Event.ShowBet) {
			showBet();
			setBetable(0);
		} 
		else if (e == Event.MakeBet) {
			
			//Board.getInstance().getActivePiece().setBet(0);
			//Ska vi verkligen sätta bet till 0 när vi satt bet redan i click i TilePanel?

			int pos = Board.getInstance().getActivePiece().getPosition();
			for (int i = pos + 1; i < pos + 8; i++) {
				if (i > 43){
					return;
				}
				tilePanels[i].betable();
				repaint();
			}
			
			Board.getInstance().getActivePiece().setBet((Integer) o);
			

//			TileContainerPanel.getTilePanels()[(Integer)o +
//		                 				           Board.getInstance().getActivePiece().getPosition()].showBet();

			//TileContainerPanel.getTilePanels()[(Integer)o +
		                 				        //   Board.getInstance().getActivePiece().getPosition()].

			showBet();
			setBetable(0);
			currentBet = (Integer)o;
			TileContainerPanel.getTilePanels()[currentBet +
		                 				          Board.getInstance().getActivePiece().getPosition()].
		                 				          setBorder(new BevelBorder(BevelBorder.LOWERED));
		    
		} 
		else if (e == Event.MakeBet) {
			showBet();			
			currentBet = (Integer)o;
			setBetable(0);
			
			TileContainerPanel.getTilePanels()[currentBet +
			                                   Board.getInstance().getActivePiece().getPosition()].
			                                   setBorder(new BevelBorder(BevelBorder.LOWERED));						
			repaint();
		}
		else if(e == Event.OldPosition){
			int pos = (Integer)o;
			tilePanels[pos].removePiece(piecePanels.get(currentPiece));
		}
		else if(e == Event.NewPosition){
			int pos = (Integer)o;
			tilePanels[pos].addPiecePanel(piecePanels.get(Board.getInstance().getActivePieceIndex()));
			tilePanels[pos].repaint();
			nextPlayer();
		}
	}
	
	public static int getCurrentBet(){
		return currentBet;
	}
	
	public static int getBetable(){
		return betable;
	}
	
	public static void setBetable(int i){
		betable = i;
	}
	
	private void showBet(){
		int pos = Board.getInstance().getActivePiece().getPosition();

		for (int i = pos + 1; i < pos + 8; i++) {
			if (i > 43){
				return;
			}
			tilePanels[i].betable();
			repaint();
		}
	}
}
