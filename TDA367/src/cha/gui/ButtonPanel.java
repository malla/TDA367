package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.domain.Board;
import cha.domain.Challenge;
import cha.event.EventBus;
import cha.event.Event;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel implements IEventHandler,
		ActionListener {

	private JButton startMissionButton;
	private JButton yesButton;
	private JButton noButton;
	public JButton nextButton;
	private JButton doneButton;
	private JLabel timer;
	private TextPanel tp;
	
	private JPanel betButtons = new JPanel();
	private JPanel missionButtons = new JPanel();
	private JPanel successButtons = new JPanel();
	private JPanel challengeButtons;
	private JPanel currentPanel = new JPanel();

	


	public ButtonPanel(TextPanel panel) {
		EventBus.getInstance().register(this);
		this.tp = panel;
		
		

		timer = new JLabel();
		timer.setFont(new Font("Dialog", Font.BOLD, 20));
		yesButton = prettyButton("Yes");
		noButton = prettyButton("No");
		nextButton = prettyButton("Next");
		doneButton = prettyButton("Done");
		startMissionButton=prettyButton("Start Mission");
		
		startMissionButton.addActionListener(this);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		nextButton.addActionListener(tp);
		doneButton.addActionListener(this);
		
		betButtons.add(startMissionButton);
		missionButtons.add(nextButton, BorderLayout.WEST);
		missionButtons.add(doneButton, BorderLayout.CENTER);
		successButtons.add(noButton);
		successButtons.add(yesButton);
		missionButtons.add(timer, BorderLayout.EAST);

		startMissionButton.setVisible(true);
		nextButton.setVisible(true);
		doneButton.setVisible(true);
		yesButton.setVisible(true);
		noButton.setVisible(true);
		timer.setVisible(true);

		this.setBackground(Color.WHITE);
		betButtons.setBackground(Color.WHITE);
		missionButtons.setBackground(Color.WHITE);
		successButtons.setBackground(Color.WHITE);
		
//		this.setBackground(Color.YELLOW);
//		betButtons.setBackground(Color.RED);
//		missionButtons.setBackground(Color.BLUE);
//		successButtons.setBackground(Color.GREEN);
		
		this.add(betButtons, BorderLayout.CENTER);
		betButtons.setPreferredSize(new Dimension(400, 40));
		this.add(missionButtons, BorderLayout.CENTER);
		missionButtons.setPreferredSize(new Dimension(400, 40));
		this.add(successButtons, BorderLayout.CENTER);
		successButtons.setPreferredSize(new Dimension(400, 40));

		currentPanel=betButtons;
		setPanel();
	}
	private JButton prettyButton(String s){
		JButton temp= new JButton(s);
		temp.setPreferredSize(new Dimension(120, 30));
		return temp;
	}
	
	
	private void setPanel(){
		betButtons.setVisible(false);
		missionButtons.setVisible(false);
		successButtons.setVisible(false);
		currentPanel.setVisible(true);
	}

	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.ShowBet) {
			currentPanel=betButtons;
			setPanel();
			startMissionButton.setVisible(false);
		} else if (e == Event.MakeBet) {
			startMissionButton.setVisible(true);
			currentPanel=betButtons;
			setPanel();
		} else if (e == Event.StartMission) {
			currentPanel=missionButtons;
			setPanel();
		} else if (e == Event.TimeOver) {
			System.out.println("ButtonPanel: Notice Event TimeOver");

			if (Challenge.isChallengeActive() == true) {
				currentPanel=betButtons;
				setPanel();
			} else if (Challenge.ChallengeEnded) {
				currentPanel=betButtons;
				setPanel();
				Challenge.ChallengeEnded = false;
			} else {
				currentPanel=successButtons;
				setPanel();
			}
		} else if (e == Event.TimeTick) {
			String time = (String) o;
			timer.setText(time);
		} else if (e == Event.IsChallenge) {
			currentPanel=betButtons;
			setPanel();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startMissionButton) {
			if (Challenge.isChallengeActive() != true) {
				TileContainerPanel.setBetable(true);
				Board.getInstance().getActivePiece()
						.setBet(TileContainerPanel.getTemporaryBet());
				for (TilePanel panel : TileContainerPanel.getTilePanels()) {
					panel.notBetable();
				}
			}
			Board.getInstance().startMission();
		} else if (e.getSource() == doneButton) {
			System.out.println("ButtonPanel: Done button pressed.");
			if (Challenge.isChallengeActive() == true) {
				// System.out.println("ButtonPanel: Done button pressed. Challenge = TRUE");
				Challenge.chaMission.stopTimer();
			} else {
				// System.out.println("ButtonPanel: Done button pressed. Challenge = FALSE");
				Board.getInstance().getMission().stopTimer();
			}

		} else if (e.getSource() == yesButton) {
			Board.getInstance().getMission().missionDone(true);
			Board.getInstance().changeActivePiece();

		} else if (e.getSource() == noButton) {
			Board.getInstance().getMission().missionDone(false);
			Board.getInstance().changeActivePiece();

		}
	}
}