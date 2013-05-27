
package cha.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import cha.domain.Board;

/**
 * Parent class of many of the other tile panels.
 */
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

	/**Graphically adds pieces to the tile in question.
	 * @param piece the piece which is to be added
	 */
	public void addPiecePanel(PiecePanel piece) {
		panel.add(piece);
	}

	/**Graphically removes pieces to the tile in question.
	 * @param piece the piece which is to be removed
	 */
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

	/**
	 * What happens when a tile is clicked
	 */
	private void click() {
		int piecePos = Board.getInstance().getTurn().getPiece().getPosition();

		// Om betable är falsk, om
		//Kollar om man får man satsa nu
		if (!TileContainerPanel.getBetable()) {
			//Kollar om klickad Tile är giltig
			if (position > piecePos && position < piecePos + 8) {
				//
				Board.getInstance().getTurn().setTempBet(position-piecePos);
				this.setBorder(loweredBorder);
				this.repaint();
			}
		}
	}
}
