package cha.domain;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class Challenge extends TurnType {
	// private final Piece challenger;
	public Piece opponent;
	// public Category category;
//	private Mission chaMission;
	private int chaScore;
	private int oppScore;
	public String resultString;
	private static boolean ChallengeActivity;
	public static boolean ChallengeEnded;
	private static final int NUMBER_OF_CARDS = 7;

	// Challenge fönster kommer upp, frågar vem som utmanas, följande kallas
	// därefter.
	public Challenge(/* Piece activePiece, */Piece opponent) {// , Category c) {
		chaScore = -1;
		oppScore = -1;
		// this.challenger = activePiece;
		this.opponent = opponent;
		// this.category = c;
		setChallengeActivity(true);
		System.out.println("Challenge: Challenge = TRUE");
		ChallengeEnded = false;
	}

	/**
	 * This method starts the Challenge, only by creating the first mission and
	 * making it start. It is called from the Challenge constructor when a
	 * Challenge has been initiated.
	 */
	public void startMission(Category category) {
		ChallengeEnded = false;
		if (chaScore < 0) {
			mission = new Mission(category, NUMBER_OF_CARDS);
			EventBus.getInstance().publish(Event.StartMission,
					mission, null);
		} else {
			if (oppScore < 0) {
				mission = new Mission(category, NUMBER_OF_CARDS);
				EventBus.getInstance().publish(Event.StartMission,
						mission, null);
			}
		}
	}

	/**
	 * This method sets the opponent and the challengers scores. When creating a
	 * Challenge, both values are set to 11.
	 */
	public void setScore(int i) {
		if (chaScore < 0) {
			chaScore = i;
		} else if (oppScore < 0) {
			oppScore = i;
			endChallenge();
		}
	}

	/**
	 * Checks who has won the challenge and calls method to move pieces.
	 * Opponent wins at draw.
	 */
	public void getResult() {
		System.out.println("Challenge: chaScore= " + chaScore + ", oppScore= "
				+ oppScore);
		if (chaScore > oppScore) {
			Board.getInstance().missionStatus(true);
			opponent.movePieceBackward();
		} else {
			opponent.movePieceForward(oppScore);
			Board.getInstance().missionStatus(false);
		}
	}

	public void endChallenge() {
		ChallengeEnded = true;
		setChallengeActivity(false);
		mission = null;
		System.out.println("Challenge = FALSE");
		getResult();
	//	Board.getInstance().changeActivePiece();
	}

/*	public static Mission getMission() {
		return chaMission;
	}*/

	public static void setChallengeActivity(boolean b) {
		ChallengeActivity = b;
	}

	public static boolean isChallengeActive() {
		return ChallengeActivity;
	}

	public void missionDone() {
		mission.stopMission();
		EventBus.getInstance().publish(Event.TimeOver, null, null);
		System.out.println("TIMEOVER PUBLISHED FROM COUNTDOWN");
	}
	
	public int getChaScore(){
		return chaScore;
	}
}
