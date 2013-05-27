package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

public class Challenge extends TurnType {
	private Piece opponent;
	private int chaScore;
	private int oppScore;
	private final int NUMBER_OF_CARDS = 7;

	
	/** Sets up and prepares for a Challenge
	 * @param opponent is the piece of the opposing team
	 */
	public Challenge(Piece opponent) {
		chaScore = -1;
		oppScore = -1;
		this.opponent = opponent;
	}

	/**
	 * Starts the Challenge, only by creating the first mission and
	 * making it start. It is called via the abstract class Turn when
	 * the 'Start Mission button is pressed in the GUI.
	 * @param category is the 'invisible' category of the challenge tile.
	 */
	@Override
	public void startMission(Category category) {
		if (chaScore < 0) {
			mission = new Mission(category, NUMBER_OF_CARDS);
			EventBus.getInstance().publish(Event.StartMission, mission, null);
		} else {
			if (oppScore < 0) {
				mission = new Mission(category, NUMBER_OF_CARDS);
				EventBus.getInstance().publish(Event.StartMission, mission,
						null);
			}
		}
	}

	/**
	 * Sets the opponent and the challengers scores. When creating a Challenge, both
	 * values are set to -1, this is how the method knows which score to change
	 * @param score is the int value of the mission success
	 */
	@Override
	public void setScore(int score) {
		if (chaScore < 0) {
			chaScore = score;
		} else if (oppScore < 0) {
			oppScore = score;
			endChallenge();
		}
	}

	/**
	 * Checks who has won the challenge and calls method to move pieces.
	 * Opponent wins at draw.
	 */
	private void getResult() {

		if (chaScore > oppScore) {
			Board.getInstance().missionStatus(true);
			opponent.movePieceBackward();
		} else {
			opponent.movePieceForward(oppScore);
			Board.getInstance().missionStatus(false);
		}
	}

	private void endChallenge() {
		mission = null;
		getResult();
	}

	@Override
	public void missionDone() {
		mission.stopMission();
		if (chaScore == -1 || oppScore == -1) {
			EventBus.getInstance().publish(Event.GetChallengeScore, null, null);
		}
	}

	public int getChaScore() {
		return chaScore;
	}
	public int getOppScore() {
		return oppScore;
	}
}