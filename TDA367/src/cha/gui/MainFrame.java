package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import cha.domain.Board;
import cha.domain.Tile;
import cha.event.EventBus;
import cha.event.Event;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, IEventHandler{

	private static final int MIN_PLAYERS = 2;

	private static final int MAX_PLAYERS = 8;
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	
	private JMenuItem newGame;
	private JMenuItem endGame;
	private JMenuItem exitApp;
	private JMenuItem gameRules;
	
	private JButton startButton;
	private JButton rulesButton;

	private JPanel startPanel;
	private RulesPanel rulesPanel;
	private TileContainerPanel tileContainerPanel;
	
	private TextPanel textPanel;
	private ButtonPanel buttonPanel;
	private PlayerPanel playerPanel;

	// Constructor
	
	public MainFrame() {
		EventBus.getInstance().register(this);
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Meny");
		JMenu rules = new JMenu("Rules");
		
		newGame = new JMenuItem("Nytt spel");
		endGame = new JMenuItem("Avsluta spel");
		exitApp = new JMenuItem("Avsluta Challenge Accepted");
		gameRules = new JMenuItem("Rules");
		
		
		newGame.setMnemonic('N');
		endGame.setMnemonic('Q');
		exitApp.setMnemonic('W');
		gameRules.setMnemonic('R');
		
		newGame.addActionListener(this);
		endGame.addActionListener(this);
		exitApp.addActionListener(this);
		gameRules.addActionListener(this);
		
		menu.add(newGame);
		menu.add(endGame);
		menu.add(exitApp);
		rules.add(gameRules);
		
		this.setJMenuBar(menuBar);
		
		menuBar.add(menu);
		menuBar.add(rules);
		
		this.setLayout(new BorderLayout());
		
		// Init Start panel
		
		startButton = new JButton("New Game");
		rulesButton = new JButton("Rules");
		startButton.addActionListener(this);
		rulesButton.addActionListener(this);
		
		startPanel = new JPanel();
		startPanel.add(startButton);
		startPanel.add(rulesButton);
		this.add(startPanel, BorderLayout.NORTH);
		

		// Init Rules panel
		
		rulesPanel = new RulesPanel();
		rulesPanel.setVisible(false);
		this.add(rulesPanel, BorderLayout.CENTER);

		// Init Game panel

		tileContainerPanel = new TileContainerPanel();
		textPanel = new TextPanel();
		buttonPanel = new ButtonPanel();
		playerPanel = new PlayerPanel();
		
		textPanel.add(buttonPanel, BorderLayout.SOUTH);
		textPanel.add(playerPanel, BorderLayout.NORTH);
		tileContainerPanel.add(textPanel, BorderLayout.CENTER);
		
		playerPanel.setBackground(Color.WHITE);
		//tileContainerPanel.setBackground(Color.WHITE);

		tileContainerPanel.setVisible(false);
		this.add(tileContainerPanel, BorderLayout.CENTER);
		
		// Some frame settings
		
		this.setTitle("Challenge Accepted");
		this.setResizable(false);
		this.setBounds(100, 100, 710, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
	}

	// Methods

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame){
			startGame();

		} else if(e.getSource() == endGame){
			showStartPanel();
		} else if(e.getSource() == exitApp){
			int reply = JOptionPane.showConfirmDialog(null, "€r du sŠker pŒ att du vill avsluta?", null, JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION){
		      System.exit(0);
		    }
		} else if(e.getSource() == gameRules){
			showRules();
		} else if(e.getSource() == startButton){
			startGame();
		} else if(e.getSource() == rulesButton){
			showRules();
		}
	}

	@Override
	public void action(Event e, Object o) {
		if(e == Event.NewGame){
			startGame();
		} else if(e == Event.ShowGameRules){
			showRules();
		} else if(e == Event.ShowStartPanel){
			showStartPanel();
		} else if (e == Event.GameOver){
			showGameOverPanel();
		}

	}

	public void startGame(){
		String reply = null;
		int numPiece;
		while (true) {
			try {
				reply = JOptionPane.showInputDialog("Hur många lag vill ni vara? (2-8 spelare)", 2);
				if (reply == null)
					return;
				numPiece = Integer.parseInt(reply);
				if (numPiece >= MIN_PLAYERS && numPiece <= MAX_PLAYERS) {
					System.out.println("Players accepted: " + numPiece);
					break;
				}
			} catch (NumberFormatException e) { }

			JOptionPane.showMessageDialog(this, "Måste vara en siffra mellan 2-8", "Error", 

					JOptionPane.ERROR_MESSAGE, null);
		}
		
		Board.createNewBoard(numPiece);		
		tileList = Board.getInstance().getTileList();
		
		EventBus.getInstance().publish(Event.CreateBoard, tileList);
		EventBus.getInstance().publish(Event.ShowBet, 
				Board.getInstance().getActivePiece());
		// TODO: needed??
//		EventBus.getInstance().publish(Event.NextPlayer, null);
		
		showGameGUI();
	} 
	
	private void showStartPanel() {
		if (tileContainerPanel.isVisible()){
			int reply = JOptionPane.showConfirmDialog(null, "€r du sŠker pŒ att du vill avsluta?", null, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION){
				startPanel.setVisible(true);
				rulesPanel.setVisible(false);
				tileContainerPanel.setVisible(false);
		    }
		}
	}

	private void showRules() {
		
		// TODO: implementera knapp i RulesPanel (hidden from start) och implementera de tvŒ metoderna i RulesPanel.
		if (tileContainerPanel.isVisible()){
			rulesPanel.showContinueButton();
		}
		else{
			rulesPanel.hideContinuaeButton();
		}
		
		startPanel.setVisible(false);
		rulesPanel.setVisible(true);
		tileContainerPanel.setVisible(false);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void showGameGUI() {
		startPanel.setVisible(false);
		rulesPanel.setVisible(false);
		tileContainerPanel.setVisible(true);
	}
	

	private void showGameOverPanel() {
		// TODO: Malla skriver denna nŠr alla paneler Šr lagade.
		
	}
	
	
}