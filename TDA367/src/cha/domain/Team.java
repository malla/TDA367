package cha.domain;

<<<<<<< HEAD
public class Team extends Piece{
	
=======
import java.awt.event.ActionListener;

public class Team extends Piece/* implements ActionListener*/{

	private String name;
	
	public Team(String name){
		this.name = name;
	}
>>>>>>> 0995c4190536b2f678421da6b8893b3e0009c385
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
