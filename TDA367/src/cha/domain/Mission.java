package cha.domain;

import java.util.List;

import cha.domain.Categories.Category;

public class Mission {

	private final CountDown timer;
	private final Piece piece;
	private Bet bet;
	private Category category;
	
	private final Deque deque = new Deque();
	private List<Card> cards;
	private Card currentCard;
	private static boolean MissionActivity;



	public Mission(Piece piece, Category category){
		this(piece, category, piece.getBet());
	}

	public Mission(Piece piece, Category category, Bet maxBet){
		this.timer = new CountDown();
		this.piece = piece;
		this.bet = maxBet;
		this.category = category;
	}
	
	//This methods only use is in the TestMission class. 
	public int dequeSize(){
		return cards.size();
	}


	public void startMission(){
		setMissionActivity(true);
		System.out.println("Mission: Mission TRUE");

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
				"\nPress 'Done' or wait until the timer has reached 0!"};
		return new Card(text);
	}

		public void timeOver(){
			//TODO
		}

		public void stopTimer(){
			timer.stopTimer();
			setMissionActivity(false);
			System.out.println("Mission: Mission FALSE");
			timeOver();
		}
		
		/** Method only called if YES or NO button is pressed*/
		public void missionDone(boolean completed){
//			EventBus.getInstance().publish(Event.OldPosition, piece.getPosition());
			if(completed){
					piece.movePieceForward(bet.getBetValue());
			}
			else{
					piece.movePieceBackward();
			}

		}
		
		public Category getCategory(){
			return category;
		}
		
		/**Returns the title of the Mission as a String*/
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
		public static void setMissionActivity(boolean b){
			MissionActivity=b;
		}
		public static boolean isMissionActive(){
			return MissionActivity;
		}
	}