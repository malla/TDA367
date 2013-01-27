package cha.gui;

import javax.swing.JOptionPane;

import cha.domain.Board;
import cha.domain.Piece;
//import cha.event.Event;
//import cha.event.IEventHandler;

public class ChallengePanel{// implements IEventHandler {

	public ChallengePanel() {
		String inputOppTeam;
		int numberOfTeams = Board.getInstance().getNumberOfPieces();
		Piece oppTeam = null;
		outerloop:
		while (true) {
			try {
				inputOppTeam = JOptionPane.showInputDialog(null,"Which team would you like to compete against?",
						"Chose an opponent team", JOptionPane.QUESTION_MESSAGE);
				if (inputOppTeam == null) {
					continue outerloop;
				}
				for (int i = 0; i < numberOfTeams; i++) {
					if (inputOppTeam.contains(Board.getInstance()
							.getTeamName(i))){
						if(inputOppTeam.contains(Board.getInstance().getActivePiece().getTeam().getName())){
							
							JOptionPane.showMessageDialog(null, "You can't compete against yourself",
									"Error", JOptionPane.ERROR_MESSAGE);
							continue outerloop;
						}
						else{
							for (TilePanel panel : TileContainerPanel.getTilePanels()) {
								panel.notBetable();
							}
						oppTeam = Board.getInstance().getPiece(i);
						Board.getInstance().startChallenge(oppTeam);
						return;
						}
					}
				}
			} catch (NumberFormatException e) {
			}
			JOptionPane.showMessageDialog(null, "There is no such team");
		}		
	}

	public static int pointsEarned() {
		String pointInput;
		int points;
		while (true) {
			pointInput = JOptionPane
					.showInputDialog(null, "How many missions did you complete?", "Missions", JOptionPane.QUESTION_MESSAGE);
			try {
				points = Integer.parseInt(pointInput);
				if (pointInput == null)
					continue;
				if (points >= 0 && points <= 7) {
					System.out.println("Missions accepted " + points);
					return points;
				}
			} catch (NumberFormatException e) {
			}
			JOptionPane.showMessageDialog(null, "The number of completed missions has to be between 0-7",
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}


//	@Override
//	public void action(Event e, Object o, Object p) {
//		if (e == Event.TimeOver) {
//			System.out.println("ChallengePanel: Notice Event TimeOver");
//			Board.getInstance().getChallenge().setScore(pointsEarned());
//		}
//		
//	}
}

//String inputOppTeam;
//int numberOfTeams;
//Piece oppTeam = null;
//
//public ChallengePanel() {
//	numberOfTeams= Board.getInstance().getNumberOfPieces();
//	decideOpponent();
//	Board.getInstance().startChallenge(oppTeam);
//}
//
//private void decideOpponent(){
//	outerloop: while (true) {
//		try {
//			inputOppTeam = JOptionPane.showInputDialog(null,
//					"Which team would you like to compete against?",
//					"Chose an opponent team", JOptionPane.QUESTION_MESSAGE);
//
//			if (inputOppTeam == null) {
//				return;
//			}
//			for (int i = 0; i < numberOfTeams; i++) {
//				if (inputOppTeam.contains(Board.getInstance()
//						.getTeamName(i))) {
//					if (inputOppTeam.contains(Board.getInstance()
//							.getActivePiece().getTeam().getName())) {
//
//						JOptionPane.showMessageDialog(null,
//								"You can't compete against yourself",
//								"Error", JOptionPane.ERROR_MESSAGE);
//						continue outerloop;
//					} else
//						oppTeam = Board.getInstance().getPiece(i);
//					return;
//				}
//			}
//		} catch (NumberFormatException e) {
//		}
//		JOptionPane.showMessageDialog(null, "There is no such team");
//	}
//}