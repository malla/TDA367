package cha.domain;

import java.util.List;

import cha.domain.Categories.Category;
import cha.event.EventBus;
import cha.event.Event;

public class Mission {

	private static final int GOAL_TILE = 43;
	private final CountDown timer;
	private final Piece piece;
	private Bet bet;
	private Category category;
	
	private final Deque deque = new Deque();
	private List<Card> cards;
	private Card currentCard;

	public Mission(Piece piece, Category category){
		this.timer = new CountDown();
		this.piece = piece;
		this.bet = piece.getBet();
		this.category = category;
	}


	public void startMission(){
		cards = deque.getCards(category, bet.getBetValue());
		nextCurrentCard();
	}
	
	public void nextCurrentCard(){
		currentCard=cards.get(0);
		cards.remove(0);
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
			EventBus.getInstance().publish(Event.OldPosition, piece.getPosition());
			if(completed){

				if(piece.getPosition() + bet.getBetValue() > GOAL_TILE){
					piece.setPosition(GOAL_TILE);
					EventBus.getInstance().publish(Event.GameOver, piece.getTeam());

				}
				else{
					piece.movePieceForward(bet.getBetValue());
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
			EventBus.getInstance().publish(Event.NewPosition, piece.getPosition());
			piece.setBet(0);
		}

		@Override
		public String toString() {
			return "Mission [cards=" + cards + 
				", timer=" + timer + 
				", piece=" + piece + "]";
		}
	}