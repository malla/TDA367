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

	/**Creates the panel which announces whos turn it is.
	 * 
	 */
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
			//Changes to say which teams turn it is
			playerJLabel.setText("Active team: "
					+ Board.getInstance().getActivePiece().getTeam().getName());
			// Changes so that the active teams color is shown
			panelColor.setBackground(Board.getInstance().getActivePiece()
					.getTeam().getColor());
			// Update GUI
			this.repaint();
			
		} else if (e == Event.NewTurn) {
			playerJLabel.setText("Team: "
					+ Board.getInstance().getActivePiece().getTeam().getName()
					+ "'s turn ");
			panelColor.setBackground(Board.getInstance().getActivePiece()
					.getTeam().getColor());
			this.repaint();
		}

	}

}
