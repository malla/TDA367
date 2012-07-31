package cha.gui;

import javax.swing.JOptionPane;

import cha.domain.Board;

public class ChallengePanel {
	
	public ChallengePanel(){
		int numberOfTeams = Board.getInstance().getNumberOfPieces();
		String oppTeam = null;
		
		while(oppTeam == null){
			String inputOppTeam = JOptionPane.showInputDialog("Which team do you want to compete against?");
			for(int i = 0; i < numberOfTeams; i++){
				if(inputOppTeam.contains(Board.getInstance().getTeamName(i))){
					oppTeam = inputOppTeam;
				}
			}
		}
		while (true) {
			try {
				reply = JOptionPane
						.showInputDialog(
								"How many teams would you like to be? (2-8 players)",
								2);

				if (reply == null)
					return;
				numPiece = Integer.parseInt(reply);
				if (numPiece >= MIN_PLAYERS && numPiece <= MAX_PLAYERS) {
					System.out.println("Players accepted: " + numPiece);
					break;
				}
			} catch (NumberFormatException e) {
			}

			JOptionPane.showMessageDialog(this,
					"It has to be a number between 2-8", "Error",

					JOptionPane.ERROR_MESSAGE, null);
		}
	}
	
}
