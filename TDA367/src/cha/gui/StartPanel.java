
package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartPanel extends JPanel{

	JButton newGameButton;
	JButton rulesButton;
	MainFrame mf;
	
	public StartPanel(MainFrame mf) {
		this.mf = mf;

		setBackground(Color.BLUE);

		JPanel buttonPanel = new JPanel();
		JLabel textLabel = new JLabel();
		JPanel textPanel = new JPanel();
		JPanel centerPanel = new JPanel();

		Color backgroundPanel = new Color(25,139,202);

		centerPanel.setBackground(backgroundPanel);
		centerPanel.setLayout(new GridLayout(2,0));
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		Font startFont = new Font("Serif", Font.PLAIN, 70);
		textLabel = new JLabel("Challenge Accepted");
		textLabel.setFont(startFont);
		textPanel.setBackground(new Color(0,0,0,0));

		textPanel.add(textLabel);		

		buttonPanel.setBackground(new Color(0, 0, 0, 0));

		newGameButton = new JButton("New Game");
		rulesButton = new JButton("Rules");
		
		newGameButton.addActionListener(mf);
		rulesButton.addActionListener(mf);

		buttonPanel.add(newGameButton);
		buttonPanel.add(rulesButton);

		centerPanel.add(textPanel);
		centerPanel.add(buttonPanel);
		this.add(centerPanel, BorderLayout.CENTER);

	}
}
