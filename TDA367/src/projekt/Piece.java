package projekt;

import java.awt.Color;

public class Piece {
	private int position;
	private int piece;
	
	public void movePieceForward(int steps){
		position = position + steps;
	}
	public void movePieceBackward(){
		position = position - 2;
	}
	
	public void setColor(Color col){
		
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	public int getPiece() {
		return piece;
	}
}
