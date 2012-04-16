package cha.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import cha.domain.Board;
import cha.gui.MainFrame;

public class ChallengeAccepted implements KeyListener{

	private MainFrame mainFrame;
	
	
	public ChallengeAccepted(){
	
		this.mainFrame = new MainFrame(this);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
	
		int key = e.getKeyCode();
		if (key-30 >= 0 && key-30 < 10){
			Board.getInstance().getActivePiece().bet(key-30);
			
		}
		if (key == KeyEvent.VK_S){
			Board.getInstance().startMission();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}