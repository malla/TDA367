package cha.domain;

import cha.domain.Categories.Category;

public class Mission {
	
	private Card card;
	private Timer timer;
	private Team team;
	
	public Mission(Team team){
		timer = new Timer();
		this.team = team;
	}
	
	public static void startMission(Category c){
		// card = deque.getCard(c);
		// card.show();
		// timer.start();
	}
	
	public void timeOver(){
		//TODO
	}
	
	public void missionDone(boolean completed){
		//TODO
	}
}