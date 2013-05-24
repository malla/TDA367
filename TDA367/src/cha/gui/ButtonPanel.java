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
import cha.event.EventBus;
import cha.event.Event;
import cha.event.IEventHandler;

/**
 * Creates the buttons to be added 
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel implements IEventHandler,
ActionListener {

	private JButton startMissionButton;
	private JButton yesButton;
	private JButton noButton;
	public JButton nextButton;
	private JButton doneButton;
	private JButton setScoreButton;
	private JLabel timer;
	private TextPanel textp;

	private JPanel startButtons;
	private JPanel missionButtons;
	private JPanel successButtons;
	private JPanel currentPanel;
	private JPanel challengePanel;
	private JPanel setScore;

	//challengePanel items.
	private int noOfOpponents;
	private JComboBox<String> opponentCombo;
	private JComboBox<Integer> scoreCombo;
	private JButton challengeButton;

	public ButtonPanel(TextPanel panel) {
		EventBus.getInstance().register(this);
		this.textp = panel;
		this.setPreferredSize(new Dimension(500, 50));


		//**********PANELS*********************************************
		
		currentPanel = new JPanel();
		startButtons = prettyPanel();
		missionButtons = prettyPanel();
		successButtons = prettyPanel();
		challengePanel=prettyPanel();
		setScore=prettyPanel();
		//*************************************************************

		//**********COMBO BOXES******************************************
		opponentCombo=new JComboBox<String>();
		opponentCombo.setPreferredSize(new Dimension(150, 30));
		challengePanel.add(opponentCombo);
		opponentCombo.setVisible(true);
		
		scoreCombo=new JComboBox<Integer>();
		int[] bets={0,1,2,3,4,5,6,7};
		for(int i:bets)
			scoreCombo.addItem(bets[i]);
		scoreCombo.setPreferredSize(new Dimension(150, 30));
		setScore.add(scoreCombo);
		scoreCombo.setVisible(true);
		//*************************************************************

		//**********BUTTONS********************************************
		yesButton = prettyButton("Yes");
		noButton = prettyButton("No");
		nextButton = prettyButton("Next");
		doneButton = prettyButton("Done");
		startMissionButton=prettyButton("Start Mission");
		challengeButton = prettyButton("Start Challenge");
		setScoreButton =prettyButton("Set Score");
		//Add listeners to buttons
		startMissionButton.addActionListener(this);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		nextButton.addActionListener(textp);
		doneButton.addActionListener(this);
		challengeButton.addActionListener(this);	
		setScoreButton.addActionListener(this);		
		//Divide buttons into panels
		startButtons.add(startMissionButton);
		missionButtons.add(nextButton, BorderLayout.WEST);
		missionButtons.add(doneButton, BorderLayout.CENTER);
		successButtons.add(yesButton, BorderLayout.WEST);
		successButtons.add(noButton, BorderLayout.EAST);
		challengePanel.add(challengeButton);
		setScore.add(setScoreButton);
		//Set visibility
		startMissionButton.setVisible(true);
		nextButton.setVisible(true);
		doneButton.setVisible(true);
		yesButton.setVisible(true);
		noButton.setVisible(true);
		challengeButton.setVisible(true);
		setScoreButton.setVisible(true);
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
		this.add(setScore, BorderLayout.CENTER);
		startButtons.setVisible(false);
		missionButtons.setVisible(false);
		successButtons.setVisible(false);
		challengePanel.setVisible(false);
		setScore.setVisible(false);
		//*************************************************************

		currentPanel=missionButtons;
		setPanel();
	}

	/*
	 * Makes the buttons look pretty.
	 */
	private JButton prettyButton(String s){
		JButton temp= new JButton(s);
		temp.setPreferredSize(new Dimension(150, 30));
		temp.setFont(Board.getInstance().fontSmall);
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
		opponentCombo.removeAllItems();
		noOfOpponents=Board.getInstance().getNumberOfPieces()-1;
		for(int i=0; i<=noOfOpponents; i++){
			String aTeam=Board.getInstance().getTeamName(i);
			if(aTeam!=Board.getInstance().getTurn().getPiece().getTeam().getName()){
				opponentCombo.addItem(aTeam);
			}
			
		}
	}

	private String teamChosen(){
		return (String) opponentCombo.getSelectedItem();
	}

	@Override
	public void action(Event e, Object o, Object p) {
		if (e == Event.TimeOver) {
			Board.getInstance().getTurn().getTurnType().missionDone();
		}if (e == Event.MakeBet) {
						currentPanel=startButtons;
			setPanel();
			startMissionButton.setVisible(false);
		}

		if (e == Event.UpdateBet) {
			currentPanel=startButtons;
			setPanel();
			startMissionButton.setVisible(true);
	
		} else if (e == Event.StartMission) {
			currentPanel=missionButtons;
			setPanel();
		} else if (e == Event.GetChallengeScore) {
			currentPanel=setScore;
			setPanel();
		} else if (e == Event.MissionOver) {
			currentPanel=successButtons;
			setPanel();
		} else if (e == Event.TimeTick) {
			
			String time = (String) o;
			timer.setText(time);
		} else if (e == Event.IsChallenge) {
			updateChallengeCombo();
			currentPanel=challengePanel;
			setPanel();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startMissionButton) {
			if(Board.getInstance().getTurn().getTurnType()==null){	
				Board.getInstance().initNormalTurn();
			}
			
			TileContainerPanel.setBetable(true);
			for (TilePanel panel : TileContainerPanel.getTilePanels()) {
				panel.notBetable();
			}
			Board.getInstance().getTurn().startMission();
		} 
		else if (e.getSource()==challengeButton){
			String opp=teamChosen();
			Board.getInstance().getTurn().setTempOpp(opp);
			Board.getInstance().getTurn().setTurnType();
			currentPanel=startButtons;
			setPanel();
		}
		else if (e.getSource()==setScoreButton){
			int score=(Integer)scoreCombo.getSelectedItem();
			Board.getInstance().getTurn().getTurnType().setScore(score);
			if(Board.getInstance().getTurn().isTurnOver()){
				Board.getInstance().newTurn();
			}
			else
			currentPanel=startButtons;
			setPanel();
		}
		else if (e.getSource() == doneButton) {		//mission shall end
			Board.getInstance().stopMission();
		} 
		else if (e.getSource() == yesButton) {	//turn shall end
			Board.getInstance().getTurn().finishTurn(true);
			Board.getInstance().newTurn();
			
		} 
		else if (e.getSource() == noButton) {		//turn shall end
			Board.getInstance().getTurn().finishTurn(false);
			Board.getInstance().newTurn();

			

		}
	}
}