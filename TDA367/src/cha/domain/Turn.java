
package cha.domain;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class Turn {

	private final Piece piece;
	private TurnType tt=null;
	private Category c;
	private int steps;


	public Turn(Piece p){
		this.piece = p;
		determinType();
		c=Board.getInstance().getTile(piece.getPosition()).getCategory();
	}
	
	public Piece getPiece(){
		return piece;
	}

	private void determinType(){
		if(Board.getInstance().getTile(piece.getPosition())
				.isChallenge()){
			EventBus.getInstance().publish(Event.IsChallenge, null, null);		}
		else 
			EventBus.getInstance().publish(Event.ShowBet, piece.getIndex(), null);
	}

	public void setTurnType(int i){
		steps=i;
		tt=new NormalTurn(i);
	}

	public void setTurnType(String oppName){
		Piece oppPiece=null;
		for (int i = 0; i < Board.getInstance().numberOfPieces; i++) {
			if (oppName.contains(Board.getInstance()
					.getTeamName(i))){
				oppPiece = Board.getInstance().getPiece(i);
			}
		}
		tt=new Challenge(oppPiece);
	}

	public TurnType getTurnType(){
		return tt;
	}
	
	public void setSteps(int i){
		steps=i;
	}



	public void finishTurn(boolean b){
		if(b && tt instanceof Challenge)
			piece.movePieceForward(((Challenge)tt).getChaScore());
		else if (b)piece.movePieceForward(steps);
		else piece.movePieceBackward();
	}

}

