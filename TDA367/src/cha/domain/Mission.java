package cha.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class Mission{

	private CountDown timer;
//	private final Piece piece;
//	private Bet bet;
	private Category category;
	private Deque deque = new Deque();
	private List<Card> cards;
	private Card currentCard;
	private static boolean MissionActivity;

	public Mission(Piece piece, Category category) {
	//	this(piece, category, piece.getBet());
	}

	public Mission(Category category, int numberOfCards) {
		this.timer = new CountDown();
		//this.piece = piece;
		//this.bet = maxBet;
		this.category = category;
		this.cards = deque.getCards(this.category, numberOfCards);
		setMissionActivity(true);
	}

	public int getDequeSize() {
		return cards.size();
	}

	public Card nextCurrentCard() {
		if (!cards.isEmpty()) {
			currentCard = cards.get(0);
			cards.remove(0);
			return currentCard;
		} else
			stopMission();
		String[] text = new String[] { "There are no more cards for your assignments! "
				+ "\nPress 'Done' or wait until the timer has reached 0!" };
		return new Card(text);
	}

	public void stopMission() {
		System.out.println("Mission:Timer should stop now");
		timer.stopTimer();
	}



	/** Method only called if YES or NO button is pressed */
/*	public void missionDone(boolean completed) {
		System.out.println("Mission: missionDone");
		if (Challenge.isChallengeActive() != true) {
			if (completed) {
				piece.movePieceForward(bet.getBetValue());
			} else {
				piece.movePieceBackward();
			}
		}
		EventBus.getInstance().publish(Event.MissionOver, null, null);
		setMissionActivity(false);
		System.out.println("*******************I MISSIONDONE***************");
	} */

	public Category getCategory() {
		return category;
	}

	/** Returns the title of the Mission as a String */
	public String getTitle() {
		String title;
		if (category == Category.BACKWARDS) {
			title = "Backwards!";
		} else if (category == Category.BODYTOBODY) {
			title = "Body to body!";
		} else if (category == Category.SAMECLASS) {
			title = "Same category!";
		} else {
			title = "Word jumble!";
		}
		return title;
	}

	@Override
	public String toString() {
		return "Mission [cards=" + cards + ", timer=" + timer /*+ ", piece="
		+ piece*/ + "]";
	}

	private void setMissionActivity(boolean b) {
		MissionActivity = b;
		if(b==false)		
			System.out.println("Mission: Mission FALSE");
		else if(b==true)		
			System.out.println("Mission: Mission TRUE");

	}

	public static boolean isMissionActive() {
		return MissionActivity;
	}
}