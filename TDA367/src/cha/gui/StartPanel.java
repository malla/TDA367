package cha.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;

public class StartPanel extends JPanel implements ActionListener {
	
	JButton startButton;
	JButton rulesButton;
	
	public StartPanel() {
		this.setLayout(new FlowLayout());
		
		startButton = new JButton("New Game");
		rulesButton = new JButton("Rules");
		
		startButton.addActionListener(this);
		rulesButton.addActionListener(this);
		
		this.add(startButton);
		this.add(rulesButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton){
			ChallengeAccepted.getInstance().publish(Event.NewGame, null);
		}else if(e.getSource() == rulesButton){
			ChallengeAccepted.getInstance().publish(Event.ShowGameRules, null);
		}
		
	}
	
}
