package cha.gui;

import java.awt.Color;

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
	private JButton nextButton;
	private JButton doneButton;
	private JLabel timer;

	public ButtonPanel() {
		EventBus.getInstance().register(this);

		timer = new JLabel();
		timer.setFont(new Font("Dialog", Font.BOLD, 20));
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		nextButton = new JButton("Next Card");
		doneButton = new JButton("Done");
		startMissionButton = new JButton("Start Mission");
		startMissionButton.addActionListener(this);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		nextButton.addActionListener(this);
		doneButton.addActionListener(this);

		this.add(startMissionButton);
		this.add(nextButton);
		this.add(doneButton);
		this.add(yesButton);
		this.add(noButton);
		this.add(timer);

		startMissionButton.setVisible(false);
		nextButton.setVisible(false);
		doneButton.setVisible(false);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		timer.setVisible(false);

		this.setBackground(Color.WHITE);
	}

	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.ShowBet) {
//			if (Board
//					.getInstance()
//					.getTile(Board.getInstance().getActivePiece().getPosition())
//					.isChallenge()) {
				if (Challenge.isChallengeActive()){
					
				
				startMissionButton.setVisible(true);
				yesButton.setVisible(false);
				noButton.setVisible(false);
			} else {
				startMissionButton.setVisible(false);
				yesButton.setVisible(false);
				noButton.setVisible(false);
			}
		} else if (e == Event.MakeBet) {
			startMissionButton.setVisible(true);
		} else if (e == Event.StartMission) {
			startMissionButton.setVisible(false);
			nextButton.setVisible(true);
			doneButton.setVisible(true);
			timer.setVisible(true);
		} else if (e == Event.TimeOver) {
			nextButton.setVisible(false);
			doneButton.setVisible(false);
			timer.setVisible(false);
			if (Challenge.isChallengeActive() == true) {
				startMissionButton.setVisible(true);
			} else {
				yesButton.setVisible(true);
				noButton.setVisible(true);
			}
		} else if (e == Event.TimeTick) {
			String time = (String) o;
			timer.setText(time);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startMissionButton) {
			if (Challenge.isChallengeActive() == true) {
				EventBus.getInstance().publish(Event.Challenge, null, null);
				EventBus.getInstance().publish(Event.StartMission,
						Challenge.chaMission, null);
			} else {
				TileContainerPanel.setBetable(true);
				Board.getInstance().getActivePiece()
						.setBet(TileContainerPanel.getTemporaryBet());
				for (TilePanel panel : TileContainerPanel.getTilePanels()) {
					panel.notBetable();
				}
				Board.getInstance().startMission();
				EventBus.getInstance().publish(Event.StartMission,
						Board.getInstance().getMission(), null);
			}
		} else if (e.getSource() == nextButton) {
			EventBus.getInstance().publish(Event.NextCard,
					Board.getInstance().getMission(), null);
		} else if (e.getSource() == doneButton) {
			if (Challenge.isChallengeActive() == true) {
				System.out.print("\nDone button pressed. Challenge = TRUE");
				Challenge.chaMission.stopTimer();
				EventBus.getInstance().publish(Event.TimeOver, null, null);
			} else {
				System.out.print("done button pressed. CHallenge = FALSE");
				Board.getInstance().getMission().stopTimer();
				EventBus.getInstance().publish(Event.TimeOver, null, null);
			}
		} else if (e.getSource() == yesButton) {
			Board.getInstance().getMission().missionDone(true);
			EventBus.getInstance().publish(Event.MissionSuccess, null, null);
			EventBus.getInstance().publish(Event.ShowBet, null, null);
			EventBus.getInstance().publish(Event.NextPlayer, null, null);
		} else if (e.getSource() == noButton) {
			Board.getInstance().getMission().missionDone(false);
			EventBus.getInstance().publish(Event.MissionFail, null, null);
			EventBus.getInstance().publish(Event.NextPlayer, null, null);
			EventBus.getInstance().publish(Event.ShowBet, null, null);
		}
	}
}