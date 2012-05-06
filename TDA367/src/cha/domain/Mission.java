package cha.domain;

import java.util.List;
import java.util.ArrayList;

import cha.controller.ChallengeAccepted;
import cha.controller.Event;
import cha.domain.Categories.Category;

public class Mission {

	private List<Card> cards;
	private final CountDown timer;
	private final Piece piece;
	private final Deque deque = new Deque();
	private Bet actualBet;


	public Mission(Piece piece, Bet b){
		timer = new CountDown();
		this.piece = piece;
		actualBet = b;
	}


	public void startMission(Category c, int bet){
		cards = deque.getCards(c, bet);

		//	public void startMission(Category c){
		//		Deque.getCard(c, actualBet);

	}
		/*=======
	public void startMission(Category c){

		//TODO
		//deque.getCards(c, actualBet.getBetValue());

		//Deque.getCards(c, actualBet);

>>>>>>> 6352ecb4b255031c0a73608a87a0847a69ce21f1
		// timer.start();
	}*/


		//L�gga till kort i en h�g och representera fr�n h�gen




		public void timeOver(){
			//TODO
		}

		public void stopTimer(){
			timer.stopTimer();
			timeOver();
		}

		public void missionDone(boolean completed){
			ChallengeAccepted.getInstance().publish(Event.OldPosition, piece.getPosition());
			if(completed){
				if(piece.getPosition() + actualBet.getBetValue() > 43){
					piece.movePieceForward(43 - piece.getPosition());
				}
				else{
					piece.movePieceForward(actualBet.getBetValue());
				}
			}
			else{
				if(piece.getPosition() < 2){
					piece.setPosition(0);
				}
				else{
					piece.movePieceBackward();
				}
			}
			ChallengeAccepted.getInstance().publish(Event.NewPosition, piece.getPosition());
			piece.setBet(0);
		}

		@Override
		public String toString() {
			return "Mission [cards=" + cards + ", timer=" + timer + ", piece="
			+ piece + "]";
		}
	}