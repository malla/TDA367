package projekt;

import java.awt.Color;

public class Piece {
<<<<<<< HEAD
	private int position;
	private int piece;
	private Color color1;
	
	public void movePieceForward(int steps){
		position = position + steps;
	}
	public void movePieceBackward(){
		position = position - 2;
	}
	public Color color(Color i){
		Color color = new Color(piece);
		for(int n = 0; n <= 8; n++){
			Color color1 = new Color(n);
		}
		return color;
	}
	
	public void setColor(Color col){
		
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	public int getPiece() {
		return piece;
	}
=======
/**
 * @uml.property  name="position"
 */
private int position;
public void movePiece(int i){
position=position+i;
}
>>>>>>> 5c90a0746afa7916df4cda89a07bae563be2ceb1
}
