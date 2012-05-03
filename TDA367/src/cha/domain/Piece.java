§package cha.domain;

import java.awt.Color;
import java.util.ArrayList;

public class Piece {
	
	private final static Color[] availableColors = new Color[]{
		Color.red, Color.blue, Color.green, Color.magenta, 
		Color.pink, Color.yellow, Color.orange, Color.cyan 
	};
	private static ArrayList<Color> availableColorsNextRound;
	
	
	private int position;
	private int piece;
	private int bet;
	private int player;
	private Team team;
	
	public Piece(Team team){
		this.team = team;
		bet = 0;
		
		//TODO Test
		/*if (availableColorsNextRound.isEmpty()){
			for (Color color : availableColors)
				availableColorsNextRound.add(color);
		}*/
	}
	
	public void movePieceForward(int bet){
		position = position + bet;
	}
	public void movePieceBackward(){
		position = position - 2;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	public void bet(int value){
		
		this.bet = value;
	}
	
	public int getPiece() {
		return piece;
	}
	
	public int getBetAmount(){
		return bet;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public void setPlayer(int player){
		this.player = player;
	}
	
	public int getPlayer(){
		return player;
	}
	@Override
	public String toString() {
		return "Piece [position=" + position + ", piece=" + piece + ", bet=" + bet + ", player=" + player + "]";
	}

	public Team getTeam() {
		return this.team;
	}

	

}
