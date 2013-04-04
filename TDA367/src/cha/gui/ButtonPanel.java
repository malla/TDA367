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
import cha.domain.Mission;
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

	private JPanel startButtons;
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

		//**********PANELS*********************************************
		currentPanel = new JPanel();
		startButtons = prettyPanel();
		missionButtons = prettyPanel();
		successButtons = prettyPanel();
		challengePanel=prettyPanel();
		//*************************************************************
		
		//**********COMBO BOX******************************************
		combo=new JComboBox<String>();
		combo.setPreferredSize(new Dimension(150, 30));
		challengePanel.add(combo);
		combo.setVisible(true);
		//*************************************************************
		
		//**********BUTTONS********************************************
		yesButton = prettyButton("Yes");
		noButton = prettyButton("No");
		nextButton = prettyButton("Next");
		doneButton = prettyButton("Done");
		startMissionButton=prettyButton("Start Mission");
		challengeButton = prettyButton("Start Challenge");
		//Add listeners to buttons
		startMissionButton.addActionListener(this);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		nextButton.addActionListener(tp);
		doneButton.addActionListener(this);
		challengeButton.addActionListener(this);		
		//Divide buttons into panels
		startButtons.add(startMissionButton);
		missionButtons.add(nextButton, BorderLayout.WEST);
		missionButtons.add(doneButton, BorderLayout.CENTER);
		successButtons.add(noButton);
		successButtons.add(yesButton);
		challengePanel.add(challengeButton);
		//Set visibility
		startMissionButton.setVisible(true);
		nextButton.setVisible(true);
		doneButton.setVisible(true);
		yesButton.setVisible(true);
		noButton.setVisible(true);
		challengeButton.setVisible(true);
		//*************************************************************
		
		//**********TIMER**********************************************
		timer = new JLabel();
		timer.setFont(new Font("Dialog", Font.BOLD, 20));
		missionButtons.add(timer, BorderLayout.EAST);
		timer.setVisible(true);
		//*************************************************************

		//**********THIS PANEL*****************************************
		this.setBackground(Color.WHITE);
		this.add(startButtons, BorderLayout.CENTER);
		this.add(missionButtons, BorderLayout.CENTER);
		this.add(successButtons, BorderLayout.CENTER);
		this.add(challengePanel, BorderLayout.CENTER);
		startButtons.setVisible(false);
		missionButtons.setVisible(false);
		successButtons.setVisible(false);
		challengePanel.setVisible(false);
		//*************************************************************

		currentPanel=startButtons;
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
	private JPanel prettyPanel(){
		JPanel temp= new JPanel();
		temp.setPreferredSize(new Dimension(400, 40));
		temp.setBackground(Color.WHITE);
		return temp;
	}

	/*
	 * Switches between the different button-containing panels.
	 */
	private void setPanel(){
		startButtons.setVisible(false);
		missionButtons.setVisible(false);
		successButtons.setVisible(false);
		challengePanel.setVisible(false);
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

	private Piece teamChosen(){
		String chosenTeam=(String) combo.getSelectedItem();
		Piece oppTeam=null;
		for (int i = 0; i < noOfOpponents+1; i++) {
			if (chosenTeam.contains(Board.getInstance()
					.getTeamName(i))){
				oppTeam = Board.getInstance().getPiece(i);
			}
		}
		return oppTeam;
	}
	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.ShowBet) {
			System.out.println("BP: ShowBet");
			currentPanel=startButtons;
			setPanel();
			startMissionButton.setVisible(false);
		} else if (e == Event.MakeBet) {
			System.out.println("BP: MakeBet");
			if(!Mission.isMissionActive()){
			startMissionButton.setVisible(true);
			currentPanel=startButtons;
			setPanel();
			}
		} else if (e == Event.StartMission) {
			System.out.println("BP: StartMission");
			currentPanel=missionButtons;
			setPanel();
		} else if (e == Event.TimeOver) {
			System.out.println("BP: TimeOver");
			if (currentPanel!=challengePanel){
			if (Challenge.isChallengeActive() == true) {
				currentPanel=startButtons;
				setPanel();
			} else if (Challenge.ChallengeEnded) {
				currentPanel=startButtons;
				setPanel();
				Challenge.ChallengeEnded = false;
			} else {
				currentPanel=successButtons;
				setPanel();
			}}
		} else if (e == Event.NextPlayer) {
//DOES NOTHING
		} else if (e == Event.TimeTick) {
			String time = (String) o;
			timer.setText(time);
		} else if (e == Event.IsChallenge) {
			System.out.println("BP: IsChallenge");
			updateChallengeCombo();
			currentPanel=challengePanel;
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
			Piece oppteam= teamChosen();
			currentPanel=startButtons;
			setPanel();
			Board.getInstance().startChallenge(oppteam);

		}
		else if (e.getSource() == doneButton) {
			System.out.println("ButtonPanel: Done button pressed.");
			if (Challenge.isChallengeActive() == true) {
				Challenge.chaMission.stopMission();
			} else {
				Board.getInstance().getMission().stopMission();
			}

		} else if (e.getSource() == yesButton) {
			Board.getInstance().getMission().missionDone(true);
			Board.getInstance().changeActivePiece();
			
			if (Challenge.isChallengeActive() == true) {
//				Challenge.chaMission.setMissionFalse();
				Challenge.chaMission.missionDone(true);
			} else {
//				Board.getInstance().getMission().setMissionFalse();
			}

		} else if (e.getSource() == noButton) {
			Board.getInstance().getMission().missionDone(false);
			Board.getInstance().changeActivePiece();

			if (Challenge.isChallengeActive() == true) {
//				Challenge.chaMission.setMissionFalse();
				Challenge.chaMission.missionDone(true);
			} else {
//				Board.getInstance().getMission().setMissionFalse();
			}
		}
	}
}