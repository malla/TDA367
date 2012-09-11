package cha.domain;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.gui.ChallengePanel;
import cha.event.EventBus;

import cha.event.IEventHandler;

public class Challenge implements IEventHandler {
	private final Piece challenger;
	public Piece opponent;
	public Category category;
	public static Mission chaMission;
//	public static Mission oppMission;
	private Bet maxBet = new Bet(7);
	public int chaScore;
	public int oppScore;
	public String resultString;
	private static boolean ChallengeActivity;

	// Challenge fönster kommer upp, frågar vem som utmanas, följande kallas
	// därefter.
	public Challenge(Piece activePiece, Piece opponent, Category c) {
		EventBus.getInstance().register(this);
		EventBus.getInstance().publish(Event.ShowBet, null, null);
		chaScore = 11;
		oppScore = 11;
		this.challenger = activePiece;
		this.opponent = opponent;
		this.category = c;

		setChallengeActivity(true);
		System.out.print("\nChallenge = TRUE");
	}

	/**
	 * This method starts the Challenge, only by creating the first mission and
	 * making it start. It is called from the Challenge constructor when a
	 * Challenge has been initiated.
	 */
	private void startChallenge() {
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
		}
	}

	/** Checks who has won the challenge and calls method to move pieces. */
	private void getResult() {
		System.out.print("\nchaScore=" + chaScore + "\noppScore=" + oppScore);
		if (chaScore > oppScore) {
			System.out.print("\ncha won with " + chaScore + "points. opp had " + oppScore + "points");
			challenger.movePieceForward(chaScore);
			opponent.movePieceBackward();
			resultString = "Congratulations " + challenger.getTeam().getName()
					+ "! " + "\nYou have won the challenge!";
		} else { // opponent also wins at draw!
			System.out.print("\nopp won with " + oppScore + "points. cha had " + chaScore + "points");
			opponent.movePieceForward(oppScore);
			challenger.movePieceBackward();
			resultString = "Congratulations " + opponent.getTeam().getName()
					+ "! " + "\nYou have won the challenge!";
		}
	}

	public void action(Event e, Object o, Object p) {
		if (e == Event.TimeOver) {
			if (chaScore > 10) {
				setScore(ChallengePanel.pointsEarned());
				System.out.println("Challenge: Den registerade challenger poäng!");
			} else if (oppScore > 10) {
				setScore(ChallengePanel.pointsEarned());
				System.out.println("Challenge: Den registerarde opponent poäng!");
				getResult();
				endChallenge();
			}
		}
		if (e == Event.Challenge) {
			startChallenge();
			// startPart2();
		}
	}

	private void endChallenge() {
		setChallengeActivity(false);
		chaMission = null;
		System.out.print("\nChallenge = FALSE");
		EventBus.getInstance().publish(Event.NextPlayer, null, null);
//La in det i PlayerPanel där den tar hand om att byta tur redan...		
//		Board.getInstance().changeActivePiece();
		EventBus.getInstance().publish(Event.ShowBet, null, null);
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
