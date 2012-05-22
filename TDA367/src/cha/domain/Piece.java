package cha.domain;

public class Piece {
	private int position;
//	private int piece;
	private Bet bet;
	private Team team;
	
	public Piece(Team team){
		this.team = team;
		bet = new Bet(0);
	}
	
	public void movePieceForward(int bet){
		position = position + bet;
	}
	public void movePieceBackward(){
		position = position - 2;
	}

	public Team getTeam() {
		return this.team;
	}
	
//	public int getPiece() {
//		return piece;
//	}
//
//	public void setPiece(int piece) {
//		this.piece = piece;
//	}
	
	public Bet getBet(){
		return bet;
	}

	public void setBet(int newBet) {
		bet = new Bet(newBet);
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Piece [position=" + position + 
//		", piece=" + piece + 
		", bet=" + bet + "]";
	}
}
