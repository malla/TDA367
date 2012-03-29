package projekt;

import java.awt.Color;

public class Piece {

	private int position;
	private int piece;
	private Color color1;
	private int steps;
	private int player;
	
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
	
	public void bet(int key){
		this.steps = key;
	}
	
	public int getPiece() {
		return piece;
	}
	
	public int getBetAmount(){
		return steps;
	}
	
	public void setPlayer(int player){
		this.player = player;
	}
	
	public int getPlayer(){
		return player;
	}


}
