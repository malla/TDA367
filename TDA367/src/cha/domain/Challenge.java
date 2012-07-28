package cha.domain;


import cha.domain.Categories.Category;

public class Challenge {
	private final Piece challenger;
	public Piece opponent;
	Category category;
	private Mission chaMission;
	private Mission oppMission;
	private Bet maxBet=new Bet(7);
	public int chaScore;
	public int oppScore;
	public String resultString;


	//Challenge f�nster kommer upp, fr�gar vem som utmasas, f�ljande kallas d�refter.
	public Challenge(Piece activePiece, Piece opponent, Category c){
		this.challenger = activePiece;
		this.opponent = opponent;
		this.category = c;
		startChallenge(); //Duellen startar...
	}

	private void startChallenge(){
		chaMission = new Mission(challenger, category, maxBet);
		oppMission = new Mission(opponent, category, maxBet);
		chaMission.startMission();
		//h�r m�ste det komma upp dialogruta lr liknande som fr�gar hur m�nga som klarades av.
		//varp� setChaScore() anropas.
		oppMission.startMission();
		//h�r m�ste det komma upp dialogruta lr liknande som fr�gar hur m�nga som klarades av.
		//varp� setOppScore() anropas.
		getResult();
	}
	//Called when challenger has done their Mission.
	public void setChaScore(int i){
		chaScore=i;
	}
	//Called when opponent has done their Mission.
	public void setOppScore(int i){
		oppScore=i;
	}

	private void getResult(){
		if (chaScore>oppScore){
			challenger.movePieceForward(chaScore);
			opponent.movePieceBackward();
			resultString = "Congratulations "+ challenger.getTeam().getName()+"! " +
					"\nYou have won the challenge!";
		}
		else { //opponent also wins at draw!
			opponent.movePieceForward(oppScore);
			challenger.movePieceBackward();
			resultString = "Congratulations "+ opponent.getTeam().getName()+"! " +
					"\nYou have won the challenge!";

		}

	}

}
