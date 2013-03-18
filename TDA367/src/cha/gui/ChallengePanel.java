package cha.gui;

import javax.swing.JOptionPane;

import cha.domain.Challenge;

public class ChallengePanel{

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
					Challenge.chaMission.setMissionFalse();

					return points;
				}
			} catch (NumberFormatException e) {
			}
			JOptionPane.showMessageDialog(null, "The number of completed missions has to be between 0-7",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

