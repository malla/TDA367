package cha.domain;

public class Piece {
	private static final int FAILED_MISSION_PENALTY = 2;
	private int position;
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
		position = position - FAILED_MISSION_PENALTY;
	}

	public Team getTeam() {
		return this.team;
	}
	
	public Bet getBet(){
		return bet;
	}

	public void setBet(int newBet) {
		if(newBet < 0){
			throw new IllegalArgumentException();	
		}
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
		return "Piece [position = " + position + 
		", bet = " + bet + "]";
	}
}
