package cha.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import cha.domain.Board;
import cha.gui.MainFrame;

public class ChallengeAccepted{

	private static ChallengeAccepted instance = null;
	private MainFrame mainFrame;

		
	public ChallengeAccepted(){
	
		this.mainFrame = new MainFrame(this);
	}
	
	
	private void ActionListener(){
		
	}

	private void ActionEvent(){
		
	}

	private Board board;
	
	
	public static ChallengeAccepted getInstance(){
		if(instance == null){
			instance = new ChallengeAccepted();
		}
		return instance;

	}
	
	public Board getBoard(){
		return board;
	}
}