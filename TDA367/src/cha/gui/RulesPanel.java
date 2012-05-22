package cha.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import cha.event.Event;
import cha.event.EventBus;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class RulesPanel extends JPanel implements IEventHandler, ActionListener {

	private JButton backButton, continueButton;
	private JLabel textField;
	private JLabel title;

	public RulesPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = c.weighty = 1;
		
		continueButton = new JButton("Continue Game");
		continueButton.setVisible(false);
		continueButton.addActionListener(this);
		this.add(continueButton, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.NORTH;
		
		title = new JLabel("Game rules ");
		Font titleFont = title.getFont();
		title.setFont(new Font(titleFont.getName(), titleFont.getStyle(), 42));
		this.add(title, c);
		
		c.gridx = 2;
		c.anchor = GridBagConstraints.NORTHEAST;
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		this.add(backButton, c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 3;
		
		textField = new JLabel("how to play...");
		this.add(textField, c);
		
	}
	
	@Override
	public void action(Event e, Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton){
			EventBus.getInstance().publish(Event.ShowStartPanel, null);
		}else if (e.getSource() == continueButton){
			EventBus.getInstance().publish(Event.ContinueGame, null);
		}
	}

	public void showContinueButton() {
		continueButton.setVisible(true);
	}

	public void hideContinuaeButton() {
		continueButton.setVisible(false);
		
	}

}
