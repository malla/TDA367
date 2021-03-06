package cha.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates the rules panel on the main frame when that button is pressed
 */
@SuppressWarnings("serial")
public class RulesPanel extends JPanel {

	public JButton newGameButton; 
	public JButton continueButton;
	private JLabel textField;
	private JLabel title;
	private MainFrame mf;

	public RulesPanel(MainFrame mainF) {
		super(new GridBagLayout());
		
		this.mf=mainF;
		
		GridBagConstraints c = new GridBagConstraints();

		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = c.weighty = 1;

		continueButton = new JButton("Continue Game");
		continueButton.setVisible(false);
		continueButton.addActionListener(mf);
		this.add(continueButton, c);

		c.gridx = 1;
		c.anchor = GridBagConstraints.NORTH;

		title = new JLabel("Game rules ");
		Font titleFont = title.getFont();
		title.setFont(new Font(titleFont.getName(), titleFont.getStyle(), 42));
		this.add(title, c);

		c.gridx = 2;
		c.anchor = GridBagConstraints.NORTHEAST;

		newGameButton = new JButton("Start A New Game");
		newGameButton.addActionListener(mf);
		this.add(newGameButton, c);

		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 3;

		String rulesText = "<html><br>How to Play: <br>\nEvery team starts on the same tile and therefor the same competition category."
				+ "The team that begins decides how many tasks they think they will complete by pressing that amount of tiles. "
				+ "If you bet two tiles, and complete two tasks � you will move two steps forward on the board, if you bet five tiles and complete five tasks you will move five steps forwards and so on. "
				+ "If you don't complete the number of tasks you betted you will move two steps backwards. "
				+ "The team next to you will be your judge and when you press play you have 30 seconds to complete your mission. <br><br>"
				+ "Yellow � Speak backwards <br>"
				+ "Your judge will read you a word backwards and your team  will guess which word it's supposed to be. The judge will read you as many words backwards as tiles you have betted.<br><br>"
				+ "Blue � Same class<br>"
				+ "Fourteen words will appear on the card in front of you. Among these words seven will have a common denominator. "
				+ "Your task s to remember as many of the words as possible. When you feel ready, click the next button and a question will appear. Try to remember as many words as possible that answers the question.<br><br> "
				+ "Red - Body to body<br>"
				+ "On each card two body parts are displayed, which two of the team members are to put against each other. For example: foot � hand. "
				+ "When one task is finished, click the next button and two new body parts will appear. Without losing grip of the body parts displayed on the first card try to manage the second card, and so on.<br><br>"
				+ "Green � Word jumble<br>"
				+ "A card with 8 � 2 letters on it will appear. The team is to find a word with as many letters in it as the amount of tiles betted.</html>";

		textField = new JLabel(rulesText);
		this.add(textField, c);

	}

	public void showContinueButton() {
		continueButton.setVisible(true);
	}

	public void hideContinuaeButton() {
		continueButton.setVisible(false);
	}

}
