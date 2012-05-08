package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.domain.Bet;

@SuppressWarnings("serial")
public class TilePanel extends JPanel {

	JPanel panel;
	int position;

	public TilePanel() {
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		this.setPreferredSize(new Dimension(50, 50));
		this.setMinimumSize(new Dimension(50, 50));
		this.setSize(50, 50);
		this.setLayout(new BorderLayout(0, 0));

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				click();
			}
		});

		/*
		 * JPanel p2 = new JPanel(); JPanel p3 = new JPanel(); JPanel p4 = new
		 * JPanel();
		 * 
		 * p2.setBackground(color); p3.setBackground(color);
		 * p4.setBackground(color);
		 * 
		 * add(p2,BorderLayout.SOUTH); add(p3,BorderLayout.WEST);
		 * add(p4,BorderLayout.EAST);
		 */
	}

	public void addPiece(PiecePanel piece) {
		panel.add(piece);
	}

	public void removePiece(PiecePanel piece) {
		panel.remove(piece);
		this.repaint();
	}

	public void betable() {

		if(this.position == ChallengeAccepted.getInstance()
				.getBoard().getActivePiece().getBetAmount()
				+ ChallengeAccepted.getInstance().getBoard().getActivePiece()
						.getPosition()) {
			this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		} else {
		this.setBorder(new BevelBorder(BevelBorder.RAISED));
		}
		
	}

	public void notBetable() {
		this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
	}

	private void click() {

		int piecePos = ChallengeAccepted.getInstance().getBoard()
				.getActivePiece().getPosition();
		
		int currentBet = TileContainerPanel.getCurrentBet();
		
		TileContainerPanel.getTilePanels()[currentBet
				+ ChallengeAccepted.getInstance().getBoard().getActivePiece()
						.getPosition()].setBorder(new BevelBorder(
				BevelBorder.LOWERED));
		
		// if(ChallengeAccepted.getInstance().getBoard().getActivePiece().getBetAmount()
		// == 0)
		// {

		if (ChallengeAccepted.getInstance().getBoard().getActivePiece()
				.getBetAmount() == 0) {

			if (position > piecePos && position < piecePos + 8) {

				bet(piecePos);

			}
		}
	}

	public void bet(int piecePos) {
		int bet = this.position - piecePos;
		ChallengeAccepted.getInstance().getBoard().getActivePiece().setBet(bet);
		ChallengeAccepted.getInstance().publish(Event.MakeBet, bet);
	}
}
