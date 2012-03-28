package projekt;

import projekt.Cathegories.Cathegory;

public class Mission {
	
	private Card card;
	private Bet bet;
	private Timer timer;
	private Team team;
	
	public Mission(int betNumber, Team team){
		bet = new Bet(betNumber);
		timer = new Timer();
		this.team = team;
	}
	
	public void startMission(Cathegory cathegory){
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