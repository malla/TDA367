
package cha.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import cha.domain.Board;
import cha.event.Event;
import cha.event.EventBus;

@SuppressWarnings("serial")
public class TilePanel extends JPanel {

	JPanel panel;
	int position;
	BevelBorder loweredBorder = new BevelBorder(BevelBorder.LOWERED, null,
			null, null, null);
	BevelBorder raisedBorder = new BevelBorder(BevelBorder.RAISED, null, null,
			null, null);

	public TilePanel() {
		this.setBorder(loweredBorder);
		this.setPreferredSize(new Dimension(50, 50));
		this.setMinimumSize(new Dimension(50, 50));
		this.setSize(50, 50);
		this.setLayout(new BorderLayout(0, 0));

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				click();
			}
		});
	}

	public void addPiecePanel(PiecePanel piece) {
		panel.add(piece);
	}

	public void removePiece(PiecePanel piece) {
		panel.remove(piece);
		this.repaint();
	}

	public void betable() {
		this.setBorder(raisedBorder);
	}

	public void notBetable() {
		//this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
		//		null));
		this.setBorder(loweredBorder);
	}

	private void click() {
		int piecePos = Board.getInstance().getTurn().getPiece().getPosition();
//		EventBus.getInstance().publish(Event.ShowBet, null, null);
//		//sänker clickad ruta GÖR DEN HÄR NÅGOT???
//		TileContainerPanel.getTilePanels()[Board.getInstance().getTurn().getPiece()
//				.getBet().getBetValue()
//				+ piecePos]
//				.setBorder(loweredBorder);
//
//		this.setBorder(loweredBorder);
//		this.repaint();
//
//		if (Board.getInstance().getTurn().getPiece().getBet().getBetValue() == 0) {
//		}
//
//		this.setBorder(loweredBorder);
//		this.repaint();

		// Om betable är falsk, om
		if (!TileContainerPanel.getBetable()) {		//Kollar om man får man beta nu
			if (position > piecePos && position < piecePos + 8) { //Kollar om klickad Tile är giltig
				//
				Board.getInstance().getTurn().setTempBet(position-piecePos);
				this.setBorder(loweredBorder);
				this.repaint();
				makeBet(piecePos);
			}
		}
	}

	public void makeBet(int piecePos) {
		int bet = this.position - piecePos;

		Board.getInstance().getTurn().setSteps(bet);

	}
}

