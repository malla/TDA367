package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

public class Piece {
	private final int FAILED_MISSION_PENALTY = 2;
	private int position;
	private Team team;
	private static final int GOAL_TILE = 43;
	private int index;

	public Piece(Team team, int index) {
		this.team = team;
		this.index = index;
	}

	public void movePieceForward(int bet) throws IllegalArgumentException{
		if(bet<0)
			throw new IllegalArgumentException();
		EventBus.getInstance().publish(Event.OldPosition, getPosition(), this.getIndex());
		if (position + bet >= GOAL_TILE) {
			setPosition(GOAL_TILE);
			EventBus.getInstance().publish(Event.GameOver, getTeam(), null);
		} else {
			position = position + bet;
		}
		EventBus.getInstance().publish(Event.NewPosition, getPosition(), this.getIndex());
	}

	public void movePieceBackward() {
		EventBus.getInstance().publish(Event.OldPosition, getPosition(), this.getIndex());
		if (getPosition() < 2) {
			setPosition(0);
		} else {
			position = position - FAILED_MISSION_PENALTY;
		}
		EventBus.getInstance().publish(Event.NewPosition, getPosition(), this.getIndex());
	}


	public Team getTeam() {
		return this.team;
	}

	public int getIndex(){
		return index;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Piece [position = " + position + "]";
	}
}
