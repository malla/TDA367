
package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import cha.event.EventBus;
import cha.event.Event;

@SuppressWarnings("serial")
public class StartPanel extends JPanel implements ActionListener {
	
	JButton startButton;
	JButton rulesButton;
	
	public StartPanel() {
//		super(new GridBagLayout());
		
		setBackground(Color.BLUE);
		
//		GridBagConstraints c = new GridBagConstraints();
//		
//		c.anchor = GridBagConstraints.CENTER;
//		c.weightx = c.weighty = 1;
//		c.insets = new Insets(250, 0, 0, 0);
//		c.fill = GridBagConstraints.HORIZONTAL;
		
		JPanel buttonPanel = new JPanel();
		JLabel textLabel = new JLabel();
		JPanel textPanel = new JPanel();
	
		Font startFont = new Font("Serif", Font.PLAIN, 50);
		textLabel = new JLabel("Challenge Accepted");
		textLabel.setFont(startFont);
		textPanel.setBackground(Color.BLUE);
		int typeFont = 1;
		textPanel.setBorder(BorderFactory.createEtchedBorder(typeFont, Color.black, Color.gray));
		textPanel.add(textLabel);		
		
		buttonPanel.setBackground(new Color(0, 0, 0, 0));
		
		startButton = new JButton("New Game");
		rulesButton = new JButton("Rules");
		
		startButton.addActionListener(this);
		rulesButton.addActionListener(this);
		
		buttonPanel.add(startButton);
		buttonPanel.add(rulesButton);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	
		this.add(textPanel, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton){
			EventBus.getInstance().publish(Event.NewGame, null);
		}else if(e.getSource() == rulesButton){
			EventBus.getInstance().publish(Event.ShowGameRules, null);
		}	
	}
}
