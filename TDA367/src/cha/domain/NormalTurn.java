package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

public class NormalTurn extends TurnType{

	private Bet bet;
	
	/**Creates a new turn
	 * @param newBet, the bet that the active team has set
	 */
	public NormalTurn(int newBet) {
		if (newBet < 0) {
			throw new IllegalArgumentException();
		}
		bet = new Bet(newBet);
	}

	/**
	 * Starts the Mission
	 */
	public void startMission(Category category) {
		mission = new Mission(category, bet.getBetValue());
		EventBus.getInstance().publish(Event.StartMission,
				mission, null);
	}

	public void missionDone() {
		mission.stopMission();
		EventBus.getInstance().publish(Event.MissionOver, null, null);

	}

	@Override
	public void setScore(int i) {	}
}
