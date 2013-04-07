
package cha.domain;

import cha.domain.Categories.Category;
import cha.event.Event;
import cha.event.EventBus;

public class Turn {

	private final Piece piece;
	private TurnType tt=null;
	private Category c;
	private int steps;
	private int tempBet;
	private String tempOpp;


	public Turn(Piece p){
		this.piece = p;
		tempBet=0;
		tempOpp=null;
		c=Board.getInstance().getTile(piece.getPosition()).getCategory();

	}

	public Piece getPiece(){
		return piece;
	}

	public void startMission(){
		tt.startMission(c);
	}

	public void determinType(){
		if(Board.getInstance().getTile(piece.getPosition())
				.isChallenge()){
			EventBus.getInstance().publish(Event.IsChallenge, null, null);	
	} else 
			EventBus.getInstance().publish(Event.MakeABet, null, null);
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
	public void setTurnType(){
		//REMOVE****************************************************************
		System.out.println("tempBet="+tempBet);
		if (tempOpp==null)
			System.out.println("tempOpp==null");
		else System.out.println("tempOpp!=null");
		//REMOVE****************************************************************
		if(tempBet==0){
			if(tempOpp!=null){
				Piece oppPiece=null;
				for (int i = 0; i < Board.getInstance().numberOfPieces; i++) {
					if (tempOpp.contains(Board.getInstance()
							.getTeamName(i))){
						oppPiece = Board.getInstance().getPiece(i);
					}
				}
				tt=new Challenge(oppPiece);
			}
		}
		else{
			steps=tempBet;
			tt=new NormalTurn(steps);
		}
	}

	public void setTempBet(int tb){
		tempBet=tb;
		System.out.println("Turn:UpdateBet publicerat. TempBet = "+ tb);
		EventBus.getInstance().publish(Event.UpdateBet, null, null);	//Publicerar att Tile clickats
	}
	public void setTempOpp(String s){
		tempOpp=s;
	}

	public TurnType getTurnType(){
		return tt;
	}

	public void setSteps(int i){
		steps=i;
	}



	public void finishTurn(boolean b){
		if(b && tt instanceof Challenge){
			System.out.println("finishTurn: move challenger forward");
			piece.movePieceForward(((Challenge)tt).getChaScore());
		}
		else if (b){
			System.out.println("finishTurn: move  forward");
			piece.movePieceForward(steps);}
		else {
			System.out.println("finishTurn: move backward");
			piece.movePieceBackward();
		}
		Board.getInstance().newTurn();
	}
}



