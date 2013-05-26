
package cha.domain;

import cha.event.Event;
import cha.event.EventBus;

/**
 * @author Malla
 *
 */
public class Turn {

	private final Piece piece;
	private TurnType turnType = null;
	private Category category;
	private int steps;
	private int tempBet;
	private String tempOpp;
	private boolean isTurnOver;


	public Turn(Piece newPiece){
		isTurnOver=false;
		this.piece = newPiece;
		tempBet = 0;
		tempOpp = null;
		try {
			category = Board.getInstance().getTile(piece.getPosition()).getCategory();
		}
		catch (IllegalArgumentException e){
			if(piece.getPosition()!=43)
			System.out.println(""+e);
			}
		steps = 0;
	}

	public Piece getPiece(){
		return piece;
	}

	public void startMission(){
		turnType.startMission(category);
	}

	public void determinType(){
		if(Board.getInstance().getTile(piece.getPosition())
				.isChallenge()){
			EventBus.getInstance().publish(Event.IsChallenge, null, null);	
	} else 
			EventBus.getInstance().publish(Event.MakeBet, null, null);
	}

	public void setTurnType(){
		if(tempBet==0){
			if(tempOpp!=null){
				Piece oppPiece=null;
				for (int i = 0; i < Board.getInstance().getNumberOfPieces(); i++) {
					if (tempOpp.contains(Board.getInstance()
							.getTeamName(i))){
						oppPiece = Board.getInstance().getPiece(i);
					}
				}
				turnType=new Challenge(oppPiece);
			}
		}
		else{
			steps=tempBet;
			turnType=new NormalTurn(steps);
		}
	}

	public void setTempBet(int newBet){
		tempBet=newBet;
		EventBus.getInstance().publish(Event.UpdateBet, null, null);	//Publicerar att Tile clickats
	}
	public int getBet(){
		return tempBet;
	}
	public int getSteps(){
		return steps;
	}
	public void setTempOpp(String newTempOpp){
		tempOpp = newTempOpp;
	}
	public String getTempOpp(){
		return tempOpp;
	}

	public TurnType getTurnType(){
		return turnType;
	}

	public void setSteps(int steps){
		this.steps=steps;
	}

	/**
	 * @param b to be true if player has successfully managed his NormalTurn
	 * or has won the Challenge.
	 */

	public void finishTurn(boolean b){
		movePiece(b);
		isTurnOver=true;
	}
	
	public boolean isTurnOver(){
		return isTurnOver;
	}
	
	/**
	 * @param b if true, player moves forward
	 * if false, player move backwards
	 */
	private void movePiece(boolean b){
		if(b && turnType instanceof Challenge){
			piece.movePieceForward(((Challenge)turnType).getChaScore());
		}
		else if (b){
			piece.movePieceForward(steps);
		}
		else {
			piece.movePieceBackward();
		}	
	}
}
