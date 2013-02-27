package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.domain.Board;
import cha.domain.Challenge;
import cha.domain.Piece;
import cha.event.EventBus;
import cha.event.Event;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel implements IEventHandler,
ActionListener {

	private JButton startMissionButton;
	private JButton yesButton;
	private JButton noButton;
	public JButton nextButton;
	private JButton doneButton;
	private JLabel timer;
	private TextPanel tp;

	private JPanel betButtons;
	private JPanel missionButtons;
	private JPanel successButtons;
	private JPanel currentPanel;
	private JPanel challengePanel;

	//challengePanel items.
	int noOfOpponents;
	String[] allTeams;
	JComboBox<String> combo;
	JButton startChallenge;
	JButton challengeButton;
	JLabel label;

	public ButtonPanel(TextPanel panel) {
		EventBus.getInstance().register(this);
		this.tp = panel;

		timer = new JLabel();
		timer.setFont(new Font("Dialog", Font.BOLD, 20));

		//Create Panels
		betButtons = new JPanel();
		missionButtons = new JPanel();
		successButtons = new JPanel();
		currentPanel = new JPanel();
		betButtons.setPreferredSize(new Dimension(400, 40));
		missionButtons.setPreferredSize(new Dimension(400, 40));
		successButtons.setPreferredSize(new Dimension(400, 40));

		challengePanel=new JPanel();
		challengePanel.setPreferredSize(new Dimension(400, 40));
		challengePanel.setBackground(Color.GREEN);
		combo=new JComboBox<String>();
		combo.setPreferredSize(new Dimension(150, 30));
		challengePanel.add(combo);
		combo.setVisible(true);
		challengeButton = prettyButton("Start Challenge");
		challengePanel.add(challengeButton);
		challengeButton.setVisible(true);
		challengeButton.addActionListener(this);		
		this.add(challengePanel, BorderLayout.CENTER);



		//Create the buttons
		yesButton = prettyButton("Yes");
		noButton = prettyButton("No");
		nextButton = prettyButton("Next");
		doneButton = prettyButton("Done");
		startMissionButton=prettyButton("Start Mission");
		//Add listeners to buttons
		startMissionButton.addActionListener(this);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		nextButton.addActionListener(tp);
		doneButton.addActionListener(this);
		//Divide buttons into panels
		betButtons.add(startMissionButton);
		missionButtons.add(nextButton, BorderLayout.WEST);
		missionButtons.add(doneButton, BorderLayout.CENTER);
		successButtons.add(noButton);
		successButtons.add(yesButton);
		missionButtons.add(timer, BorderLayout.EAST);

		startMissionButton.setVisible(true);
		nextButton.setVisible(true);
		doneButton.setVisible(true);
		yesButton.setVisible(true);
		noButton.setVisible(true);
		timer.setVisible(true);

		this.setBackground(Color.WHITE);
		betButtons.setBackground(Color.WHITE);
		missionButtons.setBackground(Color.WHITE);
		successButtons.setBackground(Color.WHITE);

		//		this.setBackground(Color.YELLOW);
		//		betButtons.setBackground(Color.RED);
		//		missionButtons.setBackground(Color.BLUE);
		//		successButtons.setBackground(Color.GREEN);


		this.add(betButtons, BorderLayout.CENTER);
		this.add(missionButtons, BorderLayout.CENTER);
		this.add(successButtons, BorderLayout.CENTER);
		betButtons.setVisible(false);
		missionButtons.setVisible(false);
		successButtons.setVisible(false);
		challengePanel.setVisible(false);

		currentPanel=betButtons;
		setPanel();
	}

	/*
	 * Makes the buttons look pretty.
	 */
	private JButton prettyButton(String s){
		JButton temp= new JButton(s);
		temp.setPreferredSize(new Dimension(150, 30));
		return temp;
	}

	/*
	 * Switches between the different button-containing panels.
	 */
	private void setPanel(){
		betButtons.setVisible(false);
		missionButtons.setVisible(false);
		successButtons.setVisible(false);
		currentPanel.setVisible(true);
	}

	private void updateChallengeCombo(){
		noOfOpponents=Board.getInstance().getNumberOfPieces()-1;
		allTeams=new String[noOfOpponents];
		for(int i=0; i<=noOfOpponents; i++){
			String aTeam=Board.getInstance().getTeamName(i);
			if(aTeam!=Board.getInstance().getActivePiece().getTeam().getName()){
				combo.addItem(aTeam);
			}
		}
	}

	private void teamChosen(){
		String chosenTeam=(String) combo.getSelectedItem();
		Piece oppTeam=null;
		for (int i = 0; i < noOfOpponents+1; i++) {
			if (chosenTeam.contains(Board.getInstance()
					.getTeamName(i))){
				oppTeam = Board.getInstance().getPiece(i);
				Board.getInstance().startChallenge(oppTeam);
			}
		}
	}
	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.ShowBet) {
			currentPanel=betButtons;
			setPanel();
			startMissionButton.setVisible(false);
		} else if (e == Event.MakeBet) {
			startMissionButton.setVisible(true);
			currentPanel=betButtons;
			setPanel();
		} else if (e == Event.StartMission) {
			currentPanel=missionButtons;
			setPanel();
		} else if (e == Event.TimeOver) {
			System.out.println("ButtonPanel: Notice Event TimeOver");

			if (Challenge.isChallengeActive() == true) {
				currentPanel=betButtons;
				setPanel();
			} else if (Challenge.ChallengeEnded) {
				currentPanel=betButtons;
				setPanel();
				Challenge.ChallengeEnded = false;
			} else {
				currentPanel=successButtons;
				setPanel();
			}
		} else if (e == Event.TimeTick) {
			String time = (String) o;
			timer.setText(time);
		} else if (e == Event.IsChallenge) {
			System.out.println("ButtonPanel: Challenge event made it here.");
			//	challengePanel=createChallengePanel();
			updateChallengeCombo();
			currentPanel=challengePanel;
			//updateChallengePanel();
			setPanel();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startMissionButton) {
			if (Challenge.isChallengeActive() != true) {
				TileContainerPanel.setBetable(true);
				Board.getInstance().getActivePiece()
				.setBet(TileContainerPanel.getTemporaryBet());
				for (TilePanel panel : TileContainerPanel.getTilePanels()) {
					panel.notBetable();
				}
			}
			Board.getInstance().startMission();
		} 
		else if (e.getSource()==challengeButton){
			teamChosen();
		}
				else if (e.getSource() == doneButton) {
			System.out.println("ButtonPanel: Done button pressed.");
			if (Challenge.isChallengeActive() == true) {
				// System.out.println("ButtonPanel: Done button pressed. Challenge = TRUE");
				Challenge.chaMission.stopTimer();
			} else {
				// System.out.println("ButtonPanel: Done button pressed. Challenge = FALSE");
				Board.getInstance().getMission().stopTimer();
			}

		} else if (e.getSource() == yesButton) {
			Board.getInstance().getMission().missionDone(true);
			Board.getInstance().changeActivePiece();

		} else if (e.getSource() == noButton) {
			Board.getInstance().getMission().missionDone(false);
			Board.getInstance().changeActivePiece();

		}
	}
}