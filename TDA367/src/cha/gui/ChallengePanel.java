package cha.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cha.domain.Board;
import cha.domain.Piece;
//import cha.event.Event;
//import cha.event.IEventHandler;

public class ChallengePanel extends JPanel{// implements IEventHandler {

	int noOfOpponents;
	String[] allTeams;
	JComboBox<String> combo;
	JButton startChallenge;
	JLabel label;
	

	public ChallengePanel(String s){
		label=new JLabel("Choose an opponent team!");
		this.add(label);
		label.setVisible(true);
		
		noOfOpponents=Board.getInstance().getNumberOfPieces()-1;
		allTeams=new String[noOfOpponents];
		for(int i=0; i<noOfOpponents; i++){
			String aTeam=Board.getInstance().getTeamName(i);
			if(aTeam!=Board.getInstance().getActivePiece().getTeam().getName()){
				allTeams[i]=aTeam;
			}
		}
		combo=new JComboBox<String>(allTeams);
		this.add(combo);
		combo.setVisible(true);
		
		startChallenge=new JButton("Start Challenge!");
		startChallenge.setPreferredSize(new Dimension(120, 30));
		this.add(startChallenge);
		startChallenge.setVisible(true);
		
	}

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