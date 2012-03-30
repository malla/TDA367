package cha.domain;

import cha.domain.Categories.Category;

public class Mission {
	
	private static Card card;
	private Bet bet;
	private CountDown timer;
//	private Team team;
	
	
	
	
	public Mission(int betNumber, Team team){
		bet = new Bet(betNumber);
		timer = new CountDown();
	//	this.team = team;
	}
	
	public static void startMission(Tile tile){
		card = Deque.getCard(Category.BODYTOBODY); //ar satt in som exempel
		System.out.println(""+ card.getAssignment());// card.show();
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