package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

public class Challenge extends TurnType {
	private Piece opponent;
	private int chaScore;
	private int oppScore;
	private final int NUMBER_OF_CARDS = 7;

	// I ButtonPanel frågas efter motståndare. Denna klass initieras när det
	// valet har gjorts.
	public Challenge(Piece opponent) {
		chaScore = -1;
		oppScore = -1;
		this.opponent = opponent;
		System.out.println("Challenge: Challenge = TRUE");
	}

	/**
	 * This method starts the Challenge, only by creating the first mission and
	 * making it start. It is called from the Challenge constructor when a
	 * Challenge has been initiated.
	 */
	public void startMission(Category category) {
		if (chaScore < 0) {
			mission = new Mission(category, NUMBER_OF_CARDS);
			System.out.println("Challenge: EVENT StartMission");
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
	 * This method sets the opponent and the challengers scores. When creating a
	 * Challenge, both values are set to 11.
	 */
	public void setScore(int i) {
		if (chaScore < 0) {
			System.out.println("chaScore set to " + i);
			chaScore = i;
		} else if (oppScore < 0) {
			System.out.println("oppScore set to " + i);
			oppScore = i;
			endChallenge();
		}
	}

	/**
	 * Checks who has won the challenge and calls method to move pieces.
	 * Opponent wins at draw.
	 */
	private void getResult() {
		System.out.println("Challenge: chaScore= " + chaScore + ", oppScore= "
				+ oppScore);
		if (chaScore > oppScore) {
			Board.getInstance().missionStatus(true);
			System.out.println("Moving opponent back");
			opponent.movePieceBackward();
		} else {
			System.out.println("Moving opponent forward");
			opponent.movePieceForward(oppScore);
			Board.getInstance().missionStatus(false);
		}
	}

	private void endChallenge() {
		mission = null;
		System.out.println("Challenge = FALSE");
		getResult();
	}

	public void missionDone() {
		System.out.println("Challenge: missionDone()");
		mission.stopMission();
		if (chaScore == -1 || oppScore == -1) {
			System.out.println("Challenge: Published GetChallengeScore");
			EventBus.getInstance().publish(Event.GetChallengeScore, null, null);
		}
	}

	public int getChaScore() {
		return chaScore;
	}
}