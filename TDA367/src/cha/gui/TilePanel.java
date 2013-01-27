package cha.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import cha.domain.Board;

@SuppressWarnings("serial")
public class TilePanel extends JPanel {

	JPanel panel;
	int position;
	BevelBorder loweredBorder = new BevelBorder(BevelBorder.LOWERED, null,
			null, null, null);
	BevelBorder raisedBorder = new BevelBorder(BevelBorder.RAISED, null, null,
			null, null);

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
	}

	public void addPiecePanel(PiecePanel piece) {
		panel.add(piece);
	}

	public void removePiece(PiecePanel piece) {
		panel.remove(piece);
		this.repaint();
	}

	public void betable() {
		this.setBorder(new BevelBorder(BevelBorder.RAISED));
	}

	public void notBetable() {
		//this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
		//		null));
		this.setBorder(loweredBorder);
	}

	private void click() {

		int piecePos = Board.getInstance().getActivePiece().getPosition();

		TileContainerPanel.getTilePanels()[Board.getInstance().getActivePiece()
				.getBet().getBetValue()
				+ Board.getInstance().getActivePiece().getPosition()]
				.setBorder(new BevelBorder(BevelBorder.LOWERED));

		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.repaint();

		if (Board.getInstance().getActivePiece().getBet().getBetValue() == 0) {
		}

		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.repaint();

		// Om betable �r falsk, om
		if (!TileContainerPanel.getBetable()) {
			if (position > piecePos && position < piecePos + 8) {
				bet(piecePos);
			}
		}
	}

	public void bet(int piecePos) {
		int bet = this.position - piecePos;

		Board.getInstance().getActivePiece().setBet(bet);

	}
}
