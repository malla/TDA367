package cha.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.controller.IEventHandler;

public class RulesPanel extends JPanel implements IEventHandler, ActionListener {

	private JButton backButton;

	public RulesPanel() {
		this.setLayout(new GridLayout(2, 1));
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		
		this.add(new JLabel("Rulezz!"));
		this.add(backButton);
	}
	
	@Override
	public void action(Event e, Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton){
			ChallengeAccepted.getInstance().publish(Event.ShowStartPanel, null);
		}
	}

}
