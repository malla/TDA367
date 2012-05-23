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
	
	//This methods only use is in the TestMission class. 
	public int dequeSize(){
		return cards.size();
	}


	public void startMission(){
		cards = deque.getCards(category, bet.getBetValue());
		//nextCurrentCard();
	}
	
	public Card nextCurrentCard(){
		if (! cards.isEmpty()){
		currentCard=cards.get(0);
		cards.remove(0);
		return currentCard;
		}
		else timeOver();
		String[] text =new String[]{"There are no more cards for your assignments! " +
				"\nPress 'Done' or ait until the timer has reached 0!"};
		return new Card(text);
	}

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
					EventBus.getInstance().publish(Event.GameOver, piece.getTeam());				}
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
		public Category getCategory(){
			return category;
		}
		
		public String getTitle(){
			String title;
			if (category== Category.BACKWARDS){
			title= "Backwards!";
			}
			else if (category== Category.BODYTOBODY){
			title= "Body to body!";
			}
			else if (category== Category.SAMECLASS){
			title= "Same category!";
			}
			else {
			title= "Word jumble!";
			}
			return title;
		}

		@Override
		public String toString() {
			return "Mission [cards=" + cards + 
				", timer=" + timer + 
				", piece=" + piece + "]";
		}
	}