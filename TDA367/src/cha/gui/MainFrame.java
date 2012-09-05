package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import cha.domain.Team;
import cha.domain.Tile;
import cha.event.Event;
import cha.event.EventBus;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, IEventHandler {

	private static final int MIN_PLAYERS = 2;

	private static final int MAX_PLAYERS = 8;
	private ArrayList<Tile> tileList = new ArrayList<Tile>();

	private JMenuItem newGame;
	private JMenuItem endGame;
	private JMenuItem exitApp;
	private JMenuItem gameRules;

	private JButton startButton;
	private JButton rulesButton;

	private StartPanel startPanel;

	private RulesPanel rulesPanel;
	private TileContainerPanel tileContainerPanel;

	private TextPanel textPanel;
	private ButtonPanel buttonPanel;
	private PlayerPanel playerPanel;

	private GameOverPanel gameOverPanel;

	private final ArrayList<Color> colorList = new ArrayList<Color>();

	// Constructor

	public MainFrame() {
		EventBus.getInstance().register(this);
		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Menu");
		JMenu rules = new JMenu("Rules");

		newGame = new JMenuItem("New game");
		endGame = new JMenuItem("End current game");
		exitApp = new JMenuItem("Exit Challenge Accepted");
		gameRules = new JMenuItem("Rules");

		
		newGame.addActionListener(this);
		endGame.addActionListener(this);
		exitApp.addActionListener(this);
		gameRules.addActionListener(this);

		menu.add(newGame);
		menu.add(endGame);
		menu.add(exitApp);
		rules.add(gameRules);

		menuBar.add(menu);
		menuBar.add(rules);

		this.setJMenuBar(menuBar);

		this.setLayout(new GridBagLayout());
		// Filling constraint
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = c.weighty = 1;

		// Init Start panel

		startPanel = new StartPanel();
		this.add(startPanel, c);

		// Init Rules panel

		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;

		rulesPanel = new RulesPanel();
		rulesPanel.setVisible(false);
		this.add(rulesPanel, c);

		// Init Game panel

		tileContainerPanel = new TileContainerPanel();
		textPanel = new TextPanel();
		buttonPanel = new ButtonPanel();
		playerPanel = new PlayerPanel();
		playerPanel.setVisible(false);
		gameOverPanel = new GameOverPanel();

		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = c2.gridy = 1;
		c2.weightx = c2.weighty = 1;
		c2.fill = GridBagConstraints.BOTH;
		
		textPanel.add(buttonPanel, BorderLayout.SOUTH);
		textPanel.add(playerPanel, BorderLayout.NORTH);
		tileContainerPanel.add(textPanel, c2);
		gameOverPanel.setVisible(false);
		tileContainerPanel.add(gameOverPanel, c2);

		tileContainerPanel.setVisible(false);
		c.fill = GridBagConstraints.BOTH;
		this.add(tileContainerPanel, c);

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
		if (e.getSource() == newGame) {
			startGame();
		} else if (e.getSource() == endGame) {
			showStartPanel();
		} else if (e.getSource() == exitApp) {
			int reply = JOptionPane
					.showConfirmDialog(
							null,
							"Are you sure you want to quit playing Challenge Accepted?",
							null, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource() == gameRules) {
			showRules();
		} else if (e.getSource() == startButton) {
			startGame();
		} else if (e.getSource() == rulesButton) {
			showRules();
		}
	}

	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.NewGame) {
			startGame();
		} else if (e == Event.ShowGameRules) {
			showRules();
		} else if (e == Event.ShowStartPanel) {
			showStartPanel();
		} else if (e == Event.GameOver) {
			gameOverPanel.setWinnerTeam((Team) o);
			showGameOverPanel();
		} else if (e == Event.ContinueGame) {
			showGameGUI();
		}
	}

	public void startGame() {
		String reply = null;
		int numPiece;
		while (true) {
			try {
				reply = JOptionPane
						.showInputDialog(
								"How many teams would you like to be? (2-8 players)",
								2);

				if (reply == null)
					return;
				numPiece = Integer.parseInt(reply);
				if (numPiece >= MIN_PLAYERS && numPiece <= MAX_PLAYERS) {
					System.out.println("Players accepted: " + numPiece);
					break;
				}
			} catch (NumberFormatException e) {
			}

			JOptionPane.showMessageDialog(this,
					"It has to be a number between 2-8", "Error",

					JOptionPane.ERROR_MESSAGE, null);
		}

		colorList.clear();
		colorList.add(Color.WHITE);
		colorList.add(Color.GREEN);
		colorList.add(Color.YELLOW);
		colorList.add(Color.BLACK);
		colorList.add(Color.RED);
		colorList.add(Color.BLUE);
		colorList.add(Color.ORANGE);
		colorList.add(Color.CYAN);

		for (int i = 0; i < numPiece; i++) {

			String teamName = JOptionPane
					.showInputDialog("What is team number " + (i + 1)
							+ " called?");
			if (teamName.length() == 0){
				teamName= "Team " + (i+1);
			}
			
			Board.setTeamName(teamName);
		}

		Board.createNewBoard(numPiece);
		tileList = Board.getInstance().getTileList();

		EventBus.getInstance().publish(Event.CreateBoard, tileList, null);
		EventBus.getInstance().publish(Event.ShowBet,
				Board.getInstance().getActivePiece(), null);

		showGameGUI();
	}

	private void showStartPanel(){
		if (tileContainerPanel.isVisible()) {
			int reply = JOptionPane.showConfirmDialog(null,
					"Are your sure you want to quit the running game?", null,

					JOptionPane.YES_NO_OPTION);
			if (reply != JOptionPane.YES_OPTION) {
				return;
			}
		}
		Board.clearBoard();
		startPanel.setVisible(true);
		rulesPanel.setVisible(false);
		tileContainerPanel.setVisible(false);
	}

	private void showRules() {
		if (tileContainerPanel.isVisible()) {
			rulesPanel.showContinueButton();
		} else {
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
		playerPanel.setVisible(true);
	}

	private void showGameOverPanel() {
		if (!tileContainerPanel.isVisible()) {
			throw new IllegalStateException(
					"The TileContainerPanel is not visible, ergo, no game is running and therefore no one can win.");
		}
		textPanel.setVisible(false);
		gameOverPanel.setVisible(true);
	}

}