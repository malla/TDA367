package cha.domain;

import cha.domain.Categories.Category;

public class Mission {
	

	private final CountDown timer;
	private final Piece piece;
	
	public Mission(Piece piece){
		timer = new CountDown();
		this.piece = piece;
	}
	

	public void startMission(Category bodytobody, Bet b){
		Deque.getCard(bodytobody, b);
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