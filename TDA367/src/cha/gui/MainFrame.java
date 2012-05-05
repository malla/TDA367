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

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener{
	
	private JMenuItem newGame;
	private JMenuItem endGame;
	
	
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
			ChallengeAccepted.getInstance();
			new MainFrame();
			ChallengeAccepted.getInstance().createBoard();
			ChallengeAccepted.getInstance().publish(Event.ShowBet, 
					ChallengeAccepted.getInstance().getBoard().getActivePiece());
	}
	
	private TileContainerPanel tileContainerPanel;
	private TextPanel textPanel;
	private ButtonPanel buttonPanel;
	
	public MainFrame() {
		initialize();
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
		
		this.setTitle("Challange Accepted");
		this.setResizable(false);
		this.setBounds(100, 100, 710, 530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Meny");
		newGame = new JMenuItem("Nytt spel");
		endGame = new JMenuItem("Avsluta spel");
		newGame.addActionListener(this);
		endGame.addActionListener(this);
		menu.add(newGame);
		menu.add(endGame);
		menuBar.add(menu);
		setJMenuBar(menuBar);

	}
    

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame){
			Main.run();
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