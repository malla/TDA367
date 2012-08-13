package cha.gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.domain.Board;
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
	private JButton nextChallenge;
	private JLabel timer;

	public ButtonPanel() {
		EventBus.getInstance().register(this);

		timer = new JLabel();
		timer.setFont(new Font("Dialog", Font.BOLD, 20));
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		nextButton = new JButton("Next Card");
		doneButton = new JButton("Done");
		nextChallenge = new JButton("Start Challenge!");
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
		this.add(nextChallenge);
		this.add(timer);

		startMissionButton.setVisible(false);
		nextButton.setVisible(false);
		doneButton.setVisible(false);
		yesButton.setVisible(false);
		noButton.setVisible(false);
		nextChallenge.setVisible(false);
		timer.setVisible(false);

		this.setBackground(Color.WHITE);
	}

	@Override
	public void action(Event e, Object o) {
		if (e == Event.ShowBet) {
			startMissionButton.setVisible(false);
			yesButton.setVisible(false);
			noButton.setVisible(false);
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
			if (Board.isChallenge=true){
				nextChallenge.setVisible(true);}
			else{yesButton.setVisible(true);
			noButton.setVisible(true);}

		} else if (e == Event.TimeTick) {
			String time = (String) o;
			timer.setText(time);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startMissionButton) {
			TileContainerPanel.setBetable(true);

			Board.getInstance().getActivePiece()
					.setBet(TileContainerPanel.getTemporaryBet());

			for (TilePanel panel : TileContainerPanel.getTilePanels()) {
				panel.notBetable();
			}
			Board.getInstance().startMission();

			EventBus.getInstance().publish(Event.StartMission,
					Board.getInstance().getMission());
		} else if (e.getSource() == nextButton) {
			EventBus.getInstance().publish(Event.NextCard,
					Board.getInstance().getMission());
		} else if (e.getSource() == doneButton) {
			Board.getInstance().getMission().stopTimer();
			EventBus.getInstance().publish(Event.TimeOver, null);
		} else if (e.getSource() == yesButton) {
			Board.getInstance().getMission().missionDone(true);
			EventBus.getInstance().publish(Event.MissionSuccess, null);
			EventBus.getInstance().publish(Event.ShowBet, null);
			EventBus.getInstance().publish(Event.NextPlayer, null);
		} else if (e.getSource() == noButton) {
			Board.getInstance().getMission().missionDone(false);
			EventBus.getInstance().publish(Event.MissionFail, null);
			EventBus.getInstance().publish(Event.NextPlayer, null);
			EventBus.getInstance().publish(Event.ShowBet, null);
		}
	}
}