package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

public class Piece {
	private static final int FAILED_MISSION_PENALTY = 2;
	private int position;
	private Bet bet;
	private Team team;
	private static final int GOAL_TILE = 43;
	private int index;

	public Piece(Team team, int index) {
		this.team = team;
		bet = new Bet(0);
		this.index = index;
	}

	public void movePieceForward(int bet) {
		System.out.println("Piece: Moved forward");
		EventBus.getInstance().publish(Event.OldPosition, getPosition(), this.getIndex());
		if (position + bet > GOAL_TILE) {
			setPosition(GOAL_TILE);
			EventBus.getInstance().publish(Event.GameOver, getTeam(), null);
		} else {
			position = position + bet;
		}
		EventBus.getInstance().publish(Event.NewPosition, getPosition(), this.getIndex());
		setBet(0);
	}

	public void movePieceBackward() {
		System.out.println("Piece: Moved backwards");
		EventBus.getInstance().publish(Event.OldPosition, getPosition(), this.getIndex());
		if (getPosition() < 2) {
			setPosition(0);
		} else {
			position = position - FAILED_MISSION_PENALTY;
		}
		EventBus.getInstance().publish(Event.NewPosition, getPosition(), this.getIndex());
		setBet(0);
	}


	public Team getTeam() {
		return this.team;
	}

	public Bet getBet() {
		return bet;
	}

	public int getIndex(){
		return index;
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
