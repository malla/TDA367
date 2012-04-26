package cha.domain;

import java.util.List;

import java.util.ArrayList;

import cha.domain.Categories.Category;

public class Mission {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private final CountDown timer;
	private final Piece piece;
	
	public Mission(Piece piece){
		timer = new CountDown();
		this.piece = piece;
	}
	
	public void startMission(Category c){
		Card card = Deque.getCard(c);
		// timer.start();
	}
	
	/* Malla
<<<<<<< HEAD

	}*/
	public void mallastartMission(Category c, int bet){
		List<Card> cards = new ArrayList<Card>();
		//Deque.getCard(c, bet);
		Card card1 = new Card(c);
		cards.add(Deque.getCard(c));
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