package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.controller.IEventHandler;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel implements IEventHandler, ActionListener {
	
	private JButton startMissionButton;
	private JButton cancelButton;
	private JLabel timer;
	
	public ButtonPanel(){
		ChallengeAccepted.getInstance().register(this);
		
		timer = new JLabel();
		timer.setFont(new Font("Dialog", Font.BOLD, 20));
		startMissionButton = new JButton("Start Mission");
		cancelButton = new JButton("Cancel");
		startMissionButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		this.add(startMissionButton);
		this.add(cancelButton);
		this.add(timer);
		
		this.setBackground(Color.WHITE);
	}
	@Override
	public void action(Event e, Object o) {
		if(e == Event.ShowBet){
			startMissionButton.setVisible(false);
			cancelButton.setVisible(false);
		}
		else if(e == Event.MakeBet){
			startMissionButton.setVisible(true);
			cancelButton.setVisible(true);
		}
		else if(e == Event.StartMission){
			startMissionButton.setVisible(false);
			cancelButton.setVisible(false);
		}
		else if(e == Event.TimeTick){
			String time = (String)o;
			timer.setText(time);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startMissionButton){
			ChallengeAccepted.getInstance().getBoard().startMission();
			ChallengeAccepted.getInstance().publish(Event.StartMission, 
					ChallengeAccepted.getInstance().getBoard().getMission());
		}
		else if(e.getSource() == cancelButton){
			ChallengeAccepted.getInstance().publish(Event.ShowBet, null);
		}
		
	}
}
