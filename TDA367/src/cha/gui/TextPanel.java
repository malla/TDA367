package cha.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import cha.domain.Categories.Category;
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
	JPanel p2 = new JPanel();
	JPanel cardPanel = new JPanel();
	JLabel header=new JLabel();

	public TextPanel() {
		EventBus.getInstance().register(this);
		initialize();
	}

	public void initialize(){
		setLayout(new BorderLayout(0, 0));
		this.setSize(600,400);

		textArea = new JTextArea();
		textArea.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		textArea.setSize(500,300);
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setOpaque(false);
		textArea.setText("Card with info");
		add(textArea, BorderLayout.CENTER);
		textArea.setColumns(2);



		lblTime = new JLabel("Time");
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setForeground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		p1.add(lblTime, BorderLayout.EAST);
		add(p1, BorderLayout.SOUTH);



		p2.setBackground(Color.WHITE);
		p2.setPreferredSize(new Dimension(10, 75));
		p2.setMinimumSize(new Dimension(10, 75));
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		add(p2, BorderLayout.NORTH);
	}

	@Override
	public void action(Event e, Object o) {
		if(e == Event.StartMission){
			Mission mission = (Mission)o;			
			cardPanel.setMaximumSize(new Dimension(50, 50));
			cardPanel.setMinimumSize(new Dimension(50, 50));
			cardPanel.setPreferredSize(new Dimension(50, 50));
			Category c = mission.getCategory();
			Color color=setCardColor(c);

			cardPanel.setBackground(color);
			cardPanel.setForeground(color);
			cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
			this.remove(textArea);
			repaint();
			add(cardPanel);
			cardPanel.add(textArea);
			paintCard(mission);			
			String title = mission.getTitle();
			header.setText("" + title);
			header.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
			p2.add(header);

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
		else if(e == Event.MissionSuccess||e == Event.MissionFail){
			p2.remove(header);
		}
	}
	private void paintCard( Mission mission){
		String[] cardtext = mission.nextCurrentCard().getString();
		int words = cardtext.length;
		String text = "";
		if (words>1){
			for (int i=0;i<words ;i=i+2){
				text = text + cardtext[i]+"		"+ cardtext[i+1]+"\n";
			}
		}
		else {
			text = cardtext[0];
		}

		textArea.setText(text);
		validate();
		textArea.repaint();

	}

	private Color setCardColor(Category category){
		Color color;
		if (category== Category.BACKWARDS){
			color= new Color(255, 150, 150);
		}
		else if (category== Category.BODYTOBODY){
			color= new Color(255, 255, 150);
		}
		else if (category== Category.SAMECLASS){
			color= new Color(150, 150, 255);
		}
		else {
			color= new Color(150, 255, 150);
		}
		return color;
	}
}
