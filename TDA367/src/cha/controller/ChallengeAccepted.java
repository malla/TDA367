package cha.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cha.domain.Board;
import cha.gui.MainFrame;

public class ChallengeAccepted{

	private static ChallengeAccepted instance = null;
	private MainFrame mainFrame;
	private Board board;
	
	private ChallengeAccepted(){
		this.board = new Board();
		this.mainFrame = new MainFrame(this);
	}
	
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