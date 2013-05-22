package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

public class NormalTurn extends TurnType{

	private Bet bet;
	
	public NormalTurn(int newBet) {
		if (newBet < 0) {
			throw new IllegalArgumentException();
		}
		bet = new Bet(newBet);
	}

	public void startMission(Category category) {
		mission = new Mission(category, bet.getBetValue());
		System.out.println("NormalTurn: EVENT StartMission");

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
