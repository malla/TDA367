package cha.domain;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class Challenge {
	private final Piece challenger;
	public Piece opponent;
	public Category category;
	public static Mission chaMission;
	private Bet maxBet = new Bet(7);
	public int chaScore;
	public int oppScore;
	public String resultString;
	private static boolean ChallengeActivity;

	// Challenge fönster kommer upp, frågar vem som utmanas, följande kallas
	// därefter.
	public Challenge(Piece activePiece, Piece opponent, Category c) {
		chaScore = 11;
		oppScore = 11;
		this.challenger = activePiece;
		this.opponent = opponent;
		this.category = c;
		setChallengeActivity(true);
		System.out.println("Challenge: Challenge = TRUE");
	}

	/**
	 * This method starts the Challenge, only by creating the first mission and
	 * making it start. It is called from the Challenge constructor when a
	 * Challenge has been initiated.
	 */
	public void startChallenge() {
		if (chaScore > 10) {
			chaMission = new Mission(challenger, category, maxBet);
			chaMission.startMission();
		} else
			if (oppScore > 10){
			chaMission = new Mission(opponent, category, maxBet);
			chaMission.startMission();}
	}

	/**
	 * This method sets the opponent and the challengers scores. When creating a
	 * Challenge, both values are set to 11.
	 */
	public void setScore(int i) {
		if (chaScore > 10) {
			chaScore = i;
		} else if (oppScore > 10) {
			oppScore = i;
			endChallenge();
		}
	}

	/** Checks who has won the challenge and calls method to move pieces. Opponent wins at draw.*/
	public void getResult() {
		System.out.println("Challenge: chaScore= " + chaScore + ", oppScore= " + oppScore);
		if (chaScore > oppScore) {
			challenger.movePieceForward(chaScore);
			opponent.movePieceBackward();
		} else {
			opponent.movePieceForward(oppScore);
			challenger.movePieceBackward();
		}
	}

	public void endChallenge() {
		setChallengeActivity(false);
		chaMission = null;

		System.out.println("Challenge = FALSE");
		getResult();
		Board.getInstance().changeActivePiece();

	}

	public static Mission getMission() {
		return chaMission;
	}

	public static void setChallengeActivity(boolean b) {
		ChallengeActivity = b;
	}

	public static boolean isChallengeActive() {
		return ChallengeActivity;
	}
}
