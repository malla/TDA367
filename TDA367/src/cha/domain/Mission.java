package cha.domain;

import java.util.List;
import java.util.ArrayList;

import cha.domain.Categories.Category;

public class Mission {
	
	private List<Card> cards;
	private final CountDown timer;
	private final Piece piece;
	private final Deque deque = new Deque();
	
	public Mission(Piece piece){
		timer = new CountDown();
		this.piece = piece;
	}
	

	public void startMission(Category c, int bet){
		cards = deque.getCard(c, bet);
		// timer.start();
	}
	//Lägga till kort i en hög och representera från högen
		
	
	

	public void timeOver(){
		//TODO
	}

	public void missionDone(boolean completed){
		//TODO
	}
	
	@Override
	public String toString() {
		return "Mission [cards=" + cards + ", timer=" + timer + ", piece="
				+ piece + "]";
	}
}