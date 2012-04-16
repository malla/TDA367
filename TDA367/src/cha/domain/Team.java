package cha.domain;

import java.awt.event.ActionListener;

public class Team extends Piece/* implements ActionListener*/{

	private String name;
	
	public Team(String name){
		this.name = name;
		getPlayer();
	}

	/*
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
*/

	@Override
	public String toString() {
		return "Team [name=" + name + "]";
	}	
}
