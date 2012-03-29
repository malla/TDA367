package cha.domain;

import java.awt.Color;

public class Piece {

	private int position;
	private int piece;
	private Color color1;
	private int bet;
	private int player;
	
	public void movePieceForward(int bet){
		position = position + bet;
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
	
	public void bet(int value){
		
		this.bet = value;
	}
	
	public int getPiece() {
		return piece;
	}
	
	public int getBetAmount(){
		return bet;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public void setPlayer(int player){
		this.player = player;
	}
	
	public int getPlayer(){
		return player;
	}
	@Override
	public String toString() {
		return "Piece [position=" + position + ", piece=" + piece + ", color1="
				+ color1 + ", bet=" + bet + ", player=" + player + "]";
	}

	

}
