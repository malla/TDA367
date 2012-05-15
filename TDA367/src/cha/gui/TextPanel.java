package cha.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import cha.domain.Board;
import cha.domain.Mission;
import cha.event.EventBus;
import cha.event.Event;
import cha.event.IEventHandler;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class TextPanel extends JPanel implements IEventHandler {

	JTextArea textArea;
	JLabel lblTime;

	JPanel cardPanel = new JPanel();
	
	public TextPanel() {
		EventBus.getInstance().register(this);
		initialize();
	}
	
	public void initialize(){
		setLayout(new BorderLayout(0, 0));
		this.setSize(600,400);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		textArea.setSize(500,300);
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setText("Card with info");
		add(textArea, BorderLayout.CENTER);
		
		lblTime = new JLabel("Time");
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setForeground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		p1.add(lblTime, BorderLayout.EAST);
		add(p1, BorderLayout.SOUTH);
		
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.setPreferredSize(new Dimension(10, 75));
		p2.setMinimumSize(new Dimension(10, 75));
		add(p2, BorderLayout.NORTH);
	}

	@Override
	public void action(Event e, Object o) {
		if(e == Event.StartMission){
			Mission mission = (Mission)o;			
			
			cardPanel.setPreferredSize(new Dimension(400, 240));
			cardPanel.setBackground(Color.CYAN);
			cardPanel.setForeground(Color.CYAN);
			cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			this.remove(textArea);
			repaint();
			add(cardPanel);
			cardPanel.add(textArea);
			paintCard(mission);			
		
		}
		else if(e == Event.NextCard){
			Mission mission = (Mission)o;
			paintCard(mission);
		}
		
		else if(e == Event.MakeBet){
			int bet = (Integer)o;
			textArea.setText("Bet: " + bet);
		}
		else if(e == Event.ShowBet){
			textArea.setText("Make bet!");
		}
		else if(e == Event.TimeOver){
			this.remove(cardPanel);
			this.add(textArea);
			this.repaint();
			textArea.setText("Was the mission completed successfully?");
		}
		
	}
	private void paintCard( Mission mission){
		String[] cardtext = mission.nextCurrentCard().getString();
		int words = cardtext.length;
		String text = "";
		for (int i=0;i<words ;i++){
			text = text+ "\n" + cardtext[i];
		}
		textArea.setText(text);
		validate();
		textArea.repaint();
	
	}

}
