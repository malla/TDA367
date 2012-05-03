package cha.domain;

import java.util.List;
import java.util.ArrayList;

import cha.domain.Categories.Category;

public class Mission {
	
	private List<Card> cards;
	private final CountDown timer;
	private final Piece piece;
<<<<<<< HEAD
	private final Deque deque = new Deque();
=======
	private Bet actualBet;
>>>>>>> 13d03e9ee16d02b537a4b73144546b904c0ee886
	
	public Mission(Piece piece, Bet b){
		timer = new CountDown();
		this.piece = piece;
		actualBet = b;
	}
	

<<<<<<< HEAD
	public void startMission(Category c, int bet){
		cards = deque.getCard(c, bet);
=======
	public void startMission(Category c){
		Deque.getCard(c, actualBet);
>>>>>>> 13d03e9ee16d02b537a4b73144546b904c0ee886
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
		return "Mission [cards=" + cards + ", timer=" + timer + ", piece="
				+ piece + "]";
	}
}