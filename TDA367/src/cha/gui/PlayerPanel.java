package cha.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.domain.Board;
import cha.event.Event;
import cha.event.EventBus;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel implements IEventHandler {

	private JLabel playerJLabel;
	private JPanel panelColor;

	public PlayerPanel() {
		EventBus.getInstance().register(this);

		setBackground(Color.WHITE);
		panelColor = new JPanel();
		panelColor.setBorder(BorderFactory.createLineBorder(Color.black));
		Font activePlayerFont = new Font("Arial", Font.PLAIN, 18);
		playerJLabel = new JLabel();
		playerJLabel.setFont(activePlayerFont);
		this.add(playerJLabel);
		this.add(panelColor);
	}

	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.NextPlayer) {
			Board.getInstance().changeActivePiece();
			// Ändrar så att det står vems tur det är.
			playerJLabel.setText("Active team: "
					+ Board.getInstance().getActivePiece().getTeam().getName());
			// Ändrar så att aktivt lags färg visas med.
			panelColor.setBackground(Board.getInstance().getActivePiece()
					.getTeam().getColor());
			// Uppdatera GUI
			this.repaint();

			if (Board.getInstance().isTimeForChallenge()) {
				System.out.println("PlayerPanel: Challenge ska dra igång enl. boolean!");
				new ChallengePanel();
			}


		} else if (e == Event.CreateBoard) {
			playerJLabel.setText("Team: "
					+ Board.getInstance().getActivePiece().getTeam().getName()
					+ "'s turn ");
			panelColor.setBackground(Board.getInstance().getActivePiece()
					.getTeam().getColor());
			this.repaint();
		}

	}

}
