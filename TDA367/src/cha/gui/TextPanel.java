package cha.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;

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
			//cardText = ChallengeAccepted.getInstance().getBoard().getMission()
		
			/*import java.awt.BorderLayout;
			import java.awt.Color;
			import java.awt.Dimension;

			import javax.swing.BorderFactory;
			import javax.swing.JFrame;
			import javax.swing.JPanel;


			public class Try1 extends JFrame{
				public static void main(String[] args) {

					new Try1();
				}

				public Try1(){
					JPanel panel0 = new JPanel();
					this.add(panel0);
					JPanel cardPanel = new JPanel();
					cardPanel.setPreferredSize(new Dimension(400, 240));
					cardPanel.setBackground(Color.CYAN);
					cardPanel.setForeground(Color.CYAN);
					cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
					panel0.add(cardPanel);
					
					JPanel header = new JPanel();
					header.setPreferredSize(new Dimension(80, 240));
					header.setBackground(Color.WHITE);
					header.setForeground(Color.WHITE);
					//header.setLayout(BorderLayout.CENTER);
					cardPanel.add(header, BorderLayout.CENTER); //no work
					header.setAlignmentX(LEFT_ALIGNMENT); //now work

					this.setTitle("Im trying");
					this.setResizable(false);
					this.setBounds(100, 100, 710, 550);
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
					this.setVisible(true);
				}
			}
			*/
		
		}
		else if(e == Event.MakeBet){
			int bet = (Integer)o;
			textArea.setText("Bet: " + bet);
		}
		else if(e == Event.ShowBet){
			textArea.setText("Make bet!");
		}
		else if(e == Event.MissionDone){
			textArea.setText("Was the mission completed successfully?");
		}
		
	}

}
