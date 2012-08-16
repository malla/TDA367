package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

public class Piece {
	private static final int FAILED_MISSION_PENALTY = 2;
	private int position;
	private Bet bet;
	private Team team;
	private static final int GOAL_TILE = 43;

	public Piece(Team team) {
		this.team = team;
		bet = new Bet(0);
	}

	public void movePieceForward(Piece piece, int bet) {
		EventBus.getInstance().publish(Event.OldPosition, getPosition(), piece);
		if (position + bet > GOAL_TILE) {
			setPosition(GOAL_TILE);
			EventBus.getInstance().publish(Event.GameOver, getTeam(), null);
		} else {
			position = position + bet;
		}
		EventBus.getInstance().publish(Event.NewPosition, getPosition(), piece);
		setBet(0);
	}

	public void movePieceBackward(Piece piece) {
		//EventBus.getInstance().publish(Event.OldPosition, getPosition());
		EventBus.getInstance().publish(Event.OldPosition, getPosition(), piece);
		if (getPosition() < 2) {
			setPosition(0);
		} else {
			position = position - FAILED_MISSION_PENALTY;
		}
		EventBus.getInstance().publish(Event.NewPosition, getPosition(), piece);
		setBet(0);
	}
	
//	private int pos;
//	
//	private void setPos(int newPos){
//		pos=newPos;
//	}
//	
//	public int getPos(){
//		return pos;
//	}

	public Team getTeam() {
		return this.team;
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(int newBet) {
		if (newBet < 0) {
			throw new IllegalArgumentException();
		}
		bet = new Bet(newBet);
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Piece [position = " + position + ", bet = " + bet + "]";
	}
}
