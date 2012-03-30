package cha.domain;

import cha.domain.Categories.Category;

public class Mission {
	
<<<<<<< HEAD
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
=======
	private Card card;
	private Timer timer;
	private Team team;
	
	public Mission(Team team){
		timer = new Timer();
		this.team = team;
	}
	
	public void startMission(Category c){
		 card = Deque.getCard(c);
		// card.show();
>>>>>>> 4b2a074cd780ab22a897c71a2516878d10a48cdb
		// timer.start();
	}
	
	public void timeOver(){
		//TODO
	}
	
	public void missionDone(boolean completed){
		//TODO
	}
}