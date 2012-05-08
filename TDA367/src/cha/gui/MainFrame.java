package cha.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cha.Main;
import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.domain.Board;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{
	
	private JMenuItem newGame;
	private JMenuItem endGame;
	
	
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {

			new MainFrame();
			
	}
	
	private TileContainerPanel tileContainerPanel;
	private TextPanel textPanel;
	private ButtonPanel buttonPanel;
	
	public MainFrame() {
	
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Meny");
		newGame = new JMenuItem("Nytt spel");
		endGame = new JMenuItem("Avsluta spel");
		newGame.addActionListener(this);
		endGame.addActionListener(this);
		menu.add(newGame);
		menu.add(endGame);
		setJMenuBar(menuBar);
		menuBar.add(menu);
		
		//this.getContentPane();
		this.setTitle("Challange Accepted");
		this.setResizable(false);
		this.setBounds(100, 100, 710, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tileContainerPanel = new TileContainerPanel();
		textPanel = new TextPanel();
		buttonPanel = new ButtonPanel();
		
		textPanel.add(buttonPanel, BorderLayout.SOUTH);
		tileContainerPanel.add(textPanel, BorderLayout.CENTER);
		this.add(tileContainerPanel, BorderLayout.CENTER);
		
		
		
		
	}
	
	public void startGame(){
		ChallengeAccepted.getInstance();
		initialize();
		
		String reply = JOptionPane.showInputDialog("Hur många lag vill ni vara?");
				
				Boolean wrongNumber = true;
				while(wrongNumber == true){
						try {
								int numPiece = Integer.parseInt(reply);
								if(numPiece < 2 || numPiece > 8){
									reply = JOptionPane.showInputDialog("Ange hur många lag ni vill vara som ett tal mellan 2-8:");
								}
								
								else {
								wrongNumber = false;
								}
								
							}
							catch (NumberFormatException nfe){
								reply = JOptionPane.showInputDialog("Ange hur många lag ni vill vara som ett tal mellan 2-8:");
						}
				}
			
								
		ChallengeAccepted.getInstance().createBoard(Integer.parseInt(reply));
				
		ChallengeAccepted.getInstance().publish(Event.ShowBet, 
				ChallengeAccepted.getInstance().getBoard().getActivePiece());

		
	}
    

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame){
			startGame();
		}
		else if(e.getSource() == endGame){
			int reply = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill avsluta?", null, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
		    {
		      System.exit(0);
		    }
			else {		
			}
		}
	}

}