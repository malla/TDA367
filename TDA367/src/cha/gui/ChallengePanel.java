package cha.gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


//import cha.event.Event;
//import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class ChallengePanel extends JPanel{// implements IEventHandler {

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
}

