package cha.domain;

import cha.domain.Categories.Category;

public class Mission {
	

	private final CountDown timer;
	private final Piece piece;
	private Bet actualBet;
	
	public Mission(Piece piece, Bet b){
		timer = new CountDown();
		this.piece = piece;
		actualBet = b;
	}
	

	public void startMission(Category c){
		Deque.getCard(c, actualBet);
		// timer.start();
	}
	//L�gga till kort i en h�g och representera fr�n h�gen
		
	
	

	public void timeOver(){
		//TODO
	}

	public void missionDone(boolean completed){
		//TODO
	}
	
	@Override
	public String toString() {
		return "Mission [cards=" + Deque.cards + ", timer=" + timer + ", piece="
				+ piece + "]";
	}
}