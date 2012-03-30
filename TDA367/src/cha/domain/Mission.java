package cha.domain;

import cha.domain.Categories.Category;

public class Mission {
	
	private Card card;
	private final CountDown timer;
	private final Team team;
	
	public Mission(Team team){
		timer = new CountDown();
		this.team = team;
	}
	
	public void startMission(Category c){
		 card = Deque.getCard(c);
		// card.show();
		// timer.start();
	}
	
	public void timeOver(){
		//TODO
	}
	
	public void missionDone(boolean completed){
		//TODO
	}

	@Override
	public String toString() {
		return "Mission [card=" + card + ", team=" + team + "]";
	}
	
	
}