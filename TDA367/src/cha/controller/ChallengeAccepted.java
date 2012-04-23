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

	
	
	public ChallengeAccepted(){
	
		this.mainFrame = new MainFrame(this);
	}
	

	public void keyPressed(KeyEvent e) {
	
		int key = e.getKeyCode();
		if (key-30 >= 0 && key-30 < 10){
			Board.getInstance().getActivePiece().bet(key-30);
			
		}
		if (key == KeyEvent.VK_S){
			Board.getInstance().startMission();
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
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