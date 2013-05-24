
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
	private BevelBorder loweredBorder = new BevelBorder(BevelBorder.LOWERED, null,
			null, null, null);
	private BevelBorder raisedBorder = new BevelBorder(BevelBorder.RAISED, null, null,
			null, null);

	public TilePanel() {
		this.setBorder(loweredBorder);
		this.setPreferredSize(new Dimension(50, 50));
		this.setMinimumSize(new Dimension(50, 50));
		this.setSize(50, 50);
		this.setLayout(new BorderLayout(0, 0));

		this.addMouseListener(new MouseAdapter() {
			@Override
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
		this.setBorder(loweredBorder);
	}

	private void click() {
		int piecePos = Board.getInstance().getTurn().getPiece().getPosition();

		// Om betable �r falsk, om
		//Kollar om man f�r man satsa nu
		if (!TileContainerPanel.getBetable()) {
			//Kollar om klickad Tile �r giltig
			if (position > piecePos && position < piecePos + 8) {
				//
				Board.getInstance().getTurn().setTempBet(position-piecePos);
				this.setBorder(loweredBorder);
				this.repaint();
			}
		}
	}
}
