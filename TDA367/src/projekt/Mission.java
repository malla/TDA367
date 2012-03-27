package projekt;

public class Mission {
	
	private Card card;
	private Bet bet;
	private Timer timer;
	
	public Mission(int betSize){
		bet = new Bet(betSize);
		timer = new Timer();
	}
	
	public void startMission(String cathegory){
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