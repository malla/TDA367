package cha.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.controller.IEventHandler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class TileContainerPanel extends JPanel implements IEventHandler {
		
		private TilePanel[] tilePanels = new TilePanel[44];
		
    	private JPanel northPanel = new JPanel();
    	private JPanel eastPanel = new JPanel();
    	private JPanel southPanel = new JPanel();
    	private JPanel westPanel = new JPanel();
	
	    public TileContainerPanel(){
	    	setLayout(new BorderLayout(0, 0));
	        init();
	        ChallengeAccepted.getInstance().register(this);
	    }

	    private void init() {
	    	
	    	eastPanel.setPreferredSize(new Dimension(50,0));
	    	FlowLayout flowLayout_1 = (FlowLayout) eastPanel.getLayout();
	    	flowLayout_1.setAlignment(FlowLayout.LEFT);
	    	flowLayout_1.setVgap(0);
	    	flowLayout_1.setHgap(0);
	    	FlowLayout flowLayout_2 = (FlowLayout) southPanel.getLayout();
	    	flowLayout_2.setAlignment(FlowLayout.RIGHT);
	    	flowLayout_2.setVgap(0);
	    	flowLayout_2.setHgap(0);
	    	westPanel.setPreferredSize(new Dimension(50,0));
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
	    	
	    	setTiles();
	    	
	    	tilePanels[0].addPiece(new PiecePanel(Color.BLUE));
	    	tilePanels[2].addPiece(new PiecePanel(Color.GREEN));
	    	tilePanels[2].addPiece(new PiecePanel(Color.YELLOW));
	    }
	    
	    private void setTiles(){
	    	TilePanel start = new StartTilePanel();
    		tilePanels[0] = start;
    		northPanel.add(start);
    		
	    	for(int i = 1; i<14; i++){
	    		TilePanel p = new NormalTilePanel(Color.RED, i);
	    		tilePanels[i] = p;
	    		northPanel.add(p);
	    	}
	    	for(int i = 14; i<22; i++){
	    		TilePanel p = new NormalTilePanel(Color.GREEN, i);
	    		tilePanels[i] = p;
	    		eastPanel.add(p);
	    	}
	    	for(int i = 35; i>21; i--){
	    		TilePanel p = new NormalTilePanel(Color.YELLOW, i);
	    		tilePanels[i] = p;
	    		southPanel.add(p);
	    	}
	    	
	    	TilePanel goal = new GoalTilePanel();
    		tilePanels[43] = goal;
    		westPanel.add(goal);
    		
	    	for(int i = 42; i>35; i--){
	    		TilePanel p = new NormalTilePanel(Color.BLUE, i);
	    		tilePanels[i] = p;
	    		westPanel.add(p);
	    	}
	    }
	    
	    public void action(Event e, Object o){
	    	if(e == Event.ShowBet){
	    	//	int pos = ChallengeAccepted.getInstance().getBoard().getActivePiece().getPosition();
	    		int pos = 0;
	    		for(int i = pos+1; i<pos+8; i++){
	    			if(i > 43)
	    				return;
	    			tilePanels[i].betable();
	    		}
	    	}
	    	else if(e == Event.MakeBet){
	    		for(TilePanel panel : tilePanels){
	    			panel.notBetable();
	    		}
	    	}
	    }
}
