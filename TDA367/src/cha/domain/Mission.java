package cha.domain;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.domain.Categories.Category;

public class Mission {
	

	private final CountDown timer;
	private final Piece piece;
	private Bet bet;
	
	public Mission(Piece piece, Bet bet){
		timer = new CountDown();
		this.bet = bet;
		this.piece = piece;
	}
	

	public void startMission(Category c){
		Deque.getCard(c, bet.getBetValue());
		// timer.start();
	}
	//L�gga till kort i en h�g och representera fr�n h�gen
		
	
	

	public void timeOver(){
		//TODO
	}

	public void missionDone(boolean completed){
		ChallengeAccepted.getInstance().publish(Event.OldPosition, piece.getPosition());
		if(completed){
			piece.movePieceForward(bet.getBetValue());
		}
		else{
			piece.movePieceBackward();
		}
		ChallengeAccepted.getInstance().publish(Event.NewPosition, piece.getPosition());
	}
	
	@Override
	public String toString() {
		return "Mission [cards=" + Deque.cards + ", timer=" + timer + ", piece="
				+ piece + "]";
	}
}