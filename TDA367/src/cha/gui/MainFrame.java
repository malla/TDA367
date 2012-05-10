package cha.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import cha.domain.Board;
import cha.domain.Tile;
import cha.event.EventBus;
import cha.event.Event;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, IEventHandler{

	private static final int MIN_PLAYERS = 2;

	private static final int MAX_PLAYERS = 8;

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		new MainFrame();	
	}
	
	private ArrayList<Tile> tileList = new ArrayList<Tile>();
	
	private JMenuItem newGame;
	private JMenuItem endGame;
	private JMenuItem gameRules;
	
	private JButton startButton;
	private JButton rulesButton;

	
	//private StartPanel startPanel;
	private RulesPanel rulesPanel;
	private TileContainerPanel tileContainerPanel;
	
	private TextPanel textPanel;
	private ButtonPanel buttonPanel;

	public MainFrame() {
		EventBus.getInstance().register(this);
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Meny");
		JMenu rules = new JMenu("Rules");
		
		newGame = new JMenuItem("Nytt spel");
		endGame = new JMenuItem("Avsluta spel");
		gameRules = new JMenuItem("Rules");
		
		newGame.setMnemonic('N');
		endGame.setMnemonic('Q');
		gameRules.setMnemonic('R');
		
		newGame.addActionListener(this);
		endGame.addActionListener(this);
		gameRules.addActionListener(this);
		
		menu.add(newGame);
		menu.add(endGame);
		rules.add(gameRules);
		
		this.setJMenuBar(menuBar);
		
		menuBar.add(menu);
		menuBar.add(rules);
		
		this.setLayout(new FlowLayout());
		
		startButton = new JButton("New Game");
		rulesButton = new JButton("Rules");
		
		startButton.addActionListener(this);
		rulesButton.addActionListener(this);
		
		this.add(startButton);
		this.add(rulesButton);
		
		//startPanel = new StartPanel();
		rulesPanel = new RulesPanel();
		rulesPanel.setVisible(false);
		//this.add(startPanel);
		this.add(rulesPanel);
		
		this.setTitle("Challenge Accepted");
		this.setResizable(false);
		this.setBounds(100, 100, 710, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initGameGUI() {
		this.remove(startButton);
		this.remove(rulesButton);
		
		tileContainerPanel = new TileContainerPanel();
		textPanel = new TextPanel();
		buttonPanel = new ButtonPanel();
		
		textPanel.add(buttonPanel, BorderLayout.SOUTH);
		tileContainerPanel.add(textPanel, BorderLayout.CENTER);
		this.add(tileContainerPanel, BorderLayout.CENTER);
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
			// TODO: Spec. message and title
			JOptionPane.showMessageDialog(this, "message", "title", 
					JOptionPane.ERROR_MESSAGE, null);
		}
		
		initGameGUI();
		
		Board.createBoard(numPiece);		
		tileList = Board.getInstance().getTileList();

		EventBus.getInstance().publish(Event.CreateBoard, tileList);
		EventBus.getInstance().publish(Event.ShowBet, 
				Board.getInstance().getActivePiece());
	} 
    

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame){
			startGame();
		}
		else if(e.getSource() == endGame){
			int reply = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill avsluta?", null, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION){
		      System.exit(0);
		    }
		}
		else if(e.getSource() == startButton){
			startGame();
		}
		else if(e.getSource() == rulesButton){
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
		}
		
	}

	private void showStartPanel() {
		rulesPanel.setVisible(false);
	//	startPanel.setVisible(true);
		
	}

	private void showRules() {
	//	startPanel.setVisible(false);
		rulesPanel.setVisible(true);
		
	}

}