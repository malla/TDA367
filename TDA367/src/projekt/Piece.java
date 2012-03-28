package projekt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Piece implements ActionListener {
	private int position;
	private int piece;
	private int n;
	private Color color;
	
	/*public Piece(){
		piece.addActionListener(this);
	}*/
	
	/**
	 * Moves the piece forward depending on how many steps the player bet. 
	 * @param steps
	 */
	public void movePieceForward(int steps){
		position = position + steps;
	}
	/**
	 * Move the piece backward if the player doesn't accomplish the bet.
	 */
	public void movePieceBackward(){
		position = position - 2;
	}
	/**
	 * List the colors and removes the color that already been taken. 
	 * @param choCol
	 */
	//I want to list the different color and if one is taken it's place should be replaced with null. 
	public void chooseColor(){
		Color[] color = {Color.green, Color.blue, Color.magenta, Color.yellow, Color.red, Color.orange, Color.black, Color.white};
	}
	/**
	 * Set the chosen color to the players piece. 
	 */
	public void setColor(Color color){
		this.color = color;
	}
	/**
	 * Sets the piece on given place on the board.
	 * @param piece
	 */
	public void setPiece(int piece) {
		this.piece = piece;
	}
	/**
	 * Gets the place of the piece on the board. 
	 * @return
	 */
	public int getPiece() {
		return piece;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
}