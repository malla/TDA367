package cha.domain;

import cha.domain.Cathegories.Cathegory;

public class Mission {
	
	private Card card;
	private Bet bet;
	private Timer timer;
//	private Team team;
	
	
	
	
	public Mission(int betNumber, Team team){
		bet = new Bet(betNumber);
		timer = new Timer();
	//	this.team = team;
	}
	
	public static void startMission(Tile tile){
		// card = deque.getCard(cathegory);
		// card.show();
		// timer.start();
	}
	
	public void timeOver(){
		//TODO
	}
	
	public int missionDone(boolean completed){
		
		if(completed){
			return bet.getBetValue();
		}
		else{
			return -2;
		}
	}
}