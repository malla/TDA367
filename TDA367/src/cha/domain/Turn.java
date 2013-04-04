package cha.domain;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class Turn {

	private final Piece piece;
	private TurnType tt;
	private Category c;


	public Turn(Piece p){
		this.piece = p;
		determinType();
		c=Board.getInstance().getTile(piece.getPosition()).getCategory();
	}

	private void determinType(){
		if(Board.getInstance().getTile(piece.getPosition())
				.isChallenge()){
			EventBus.getInstance().publish(Event.IsChallenge, null, null);		}
		else 
			EventBus.getInstance().publish(Event.ShowBet, piece.getIndex(), null);
	}

	public void setTurnType(int i){
		tt=new NormalType(i, c);
	}

	public void setTurnType(String oppName){
		Piece oppPiece=null;
		for (int i = 0; i < Board.getInstance().numberOfPieces; i++) {
			if (oppName.contains(Board.getInstance()
					.getTeamName(i))){
				oppPiece = Board.getInstance().getPiece(i);
			}
		}
		tt=new Challenge(oppPiece, c);
	}
	
	public TurnType getTurnType(){
		return tt;
	}

	public void finishTurn(boolean b){
		if (b)moveforward();
		else moveBackwards();
	}

}
