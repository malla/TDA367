package cha.domain;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class NormalTurn extends TurnType{

	private Bet bet;
	
	public NormalTurn(int newBet) {
		if (newBet < 0) {
			throw new IllegalArgumentException();
		}
		bet = new Bet(newBet);
		EventBus.getInstance().publish(Event.MakeBet, newBet, null);
	}

	public void startMission(Category category) {
		mission = new Mission(category, bet.getBetValue());
		EventBus.getInstance().publish(Event.StartMission,
				mission, null);
	}

	public void missionDone() {
		mission.stopMission();
		EventBus.getInstance().publish(Event.TimeOver, null, null);
		System.out.println("TIMEOVER PUBLISHED FROM COUNTDOWN");
	}
}
