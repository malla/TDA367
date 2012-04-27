package cha.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.controller.IEventHandler;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class TextPanel extends JPanel implements IEventHandler {

	JTextArea cardText;
	JLabel lblTime;
	
	public TextPanel() {
		ChallengeAccepted.getInstance().register(this);
		initialize();
	}
	
	public void initialize(){
		setLayout(new BorderLayout(0, 0));
		this.setSize(600,400);
		
		cardText = new JTextArea();
		cardText.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		cardText.setSize(500,300);
		cardText.setEditable(false);
		cardText.setForeground(Color.BLACK);
		cardText.setText("Card with info");
		add(cardText, BorderLayout.CENTER);
		
		lblTime = new JLabel("Time");
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setForeground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		p1.add(lblTime, BorderLayout.EAST);
		add(p1, BorderLayout.SOUTH);
		
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(10, 75));
		p2.setMinimumSize(new Dimension(10, 75));
		p2.add(new JLabel("PlayerArea, not done"));
		add(p2, BorderLayout.NORTH);
	}

	@Override
	public void action(Event e, Object o) {
		if(e == Event.StartMission){
			//cardText = ChallengeAccepted.getInstance().getBoard().getMission()
		}
		else if(e == Event.MakeBet){
			int bet = (Integer)o;
			cardText.setText("Bet: " + bet);
		}
		else if(e == Event.ShowBet){
			cardText.setText("");
		}
		
	}

}
