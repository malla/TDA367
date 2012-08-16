
package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.event.Event;
import cha.event.EventBus;

@SuppressWarnings("serial")
public class StartPanel extends JPanel implements ActionListener {
	
	JButton startButton;
	JButton rulesButton;
	
	public StartPanel() {

		
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
		
		startButton = new JButton("New Game");
		rulesButton = new JButton("Rules");
		
		startButton.addActionListener(this);
		rulesButton.addActionListener(this);
		
		buttonPanel.add(startButton);
		buttonPanel.add(rulesButton);
		

		centerPanel.add(textPanel);
		centerPanel.add(buttonPanel);
		this.add(centerPanel, BorderLayout.CENTER);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton){
			EventBus.getInstance().publish(Event.NewGame, null, null);
		}else if(e.getSource() == rulesButton){
			EventBus.getInstance().publish(Event.ShowGameRules, null, null);
		}	
	}
}
