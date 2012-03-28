package projekt;

import java.awt.event.ActionListener;

public class Team extends Piece implements ActionListener{
	private int piece;
	private Object board;
	
	public void setPiecePos(int piece) {
		this.piece = piece;
	}
	public int getPiecePos() {
		return piece;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public Object getBoard() {
		return board;

	}
}
