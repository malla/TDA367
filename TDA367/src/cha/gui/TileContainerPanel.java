package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.controller.IEventHandler;
import cha.domain.Board;
import cha.domain.Categories.Category;
import cha.domain.Piece;
import cha.domain.Tile;

@SuppressWarnings("serial")
public class TileContainerPanel extends JPanel implements IEventHandler {

	private static TilePanel[] tilePanels = new TilePanel[44];
	private int numberOfPieces;

	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();

	private ArrayList<Color> colorList;
	private ArrayList<PiecePanel> pieces;
	private int currentPiece;
	private static int currentBet;
	private static int betable = 0;

	public TileContainerPanel() {
		setLayout(new BorderLayout(0, 0));
//		init();
		ChallengeAccepted.getInstance().register(this);
	}

	public void init(ArrayList<Tile> t) {
//		colorList = new ArrayList<Color>();
//		colorList.add(Color.BLUE);
//		colorList.add(Color.GREEN);
//		colorList.add(Color.YELLOW);
//		colorList.add(Color.RED);

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
		FlowLayout flowLayout = (FlowLayout) northPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);

		this.add(northPanel, BorderLayout.NORTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(westPanel, BorderLayout.WEST);

		setTiles(t);
		
		pieces = new ArrayList<PiecePanel>();
	 
		System.out.print(Board.getInstance().getNumberOfPieces()); 
		numberOfPieces = Board.getInstance().getNumberOfPieces();
				//Board.getNumberOfPieces();
		System.out.print(numberOfPieces);
		

		for(int i = 0 ; i < numberOfPieces; i++){
			pieces.add(new PiecePanel(ChallengeAccepted.getInstance().getBoard().getPiece(i).getTeam().getColor()));
			
		}
		
		
		for(PiecePanel piece : pieces){
			tilePanels[0].addPiece(piece);
		}
		

		currentPiece = 0;
	}

	private void setTiles(ArrayList<Tile> tiles) {
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
	}
	
	private TilePanel createTile(Tile t, int i){
		TilePanel tile;
		Category c = t.getCategory();
		if(c == Category.BACKWARDS){
			tile = new NormalTilePanel(Color.RED, i);
		}
		else if(c == Category.BODYTOBODY){
			tile = new NormalTilePanel(Color.YELLOW, i);
		}
		else if(c == Category.SAMECLASS){
			tile = new NormalTilePanel(Color.BLUE, i);
		}
		else {
			tile = new NormalTilePanel(Color.GREEN, i);
		}
		
		return tile;
	}
	
	private void nextPlayer(){
		Board.changeActivePiece();
		currentPiece = ChallengeAccepted.getInstance().getBoard().getActivePieceNumber();
	}

	public static TilePanel[] getTilePanels() {
		return tilePanels;

	}
	
	public void action(Event e, Object o) {
		if(e == Event.CreateBoard){
			ArrayList<Tile> t = (ArrayList<Tile>)o;
			init(t);
		}
		else if (e == Event.ShowBet) {
			showBet();
			setBetable(0);
		} 
		else if (e == Event.MakeBet) {
			
			//ChallengeAccepted.getInstance().getBoard().getActivePiece().setBet(0);
			//Ska vi verkligen sätta bet till 0 när vi satt bet redan i click i TilePanel?
			showBet();
			
			currentBet = (Integer)o;
			setBetable(0);
			
			TileContainerPanel.getTilePanels()[currentBet +
		                 				           ChallengeAccepted.getInstance().getBoard().getActivePiece().getPosition()].
		                				           setBorder(new BevelBorder(BevelBorder.LOWERED));
			
			//ChallengeAccepted.getInstance().publish(Event.ShowBet, null);
						
			repaint();
			
//			for (TilePanel panel : tilePanels) {
//				panel.notBetable();
//			}
		}
		else if(e == Event.OldPosition){
			int pos = (Integer)o;
			tilePanels[pos].removePiece(pieces.get(currentPiece));
		}
		else if(e == Event.NewPosition){
			int pos = (Integer)o;
			tilePanels[pos].addPiece(pieces.get(currentPiece));
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
		int pos = ChallengeAccepted.getInstance().getBoard().getActivePiece().getPosition();
		
		
		//ChallengeAccepted.getInstance().getBoard().getActivePiece().setBet(0);
		for (int i = pos + 1; i < pos + 8; i++) {
			if (i > 43){
				return;
			}
			tilePanels[i].betable();
			repaint();
		}
	}
}
