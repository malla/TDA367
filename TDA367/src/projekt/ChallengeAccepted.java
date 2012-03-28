package projekt;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class ChallengeAccepted implements KeyListener{

	private MainFrame mainFrame;
	
	public ChallengeAccepted(){
		new Board();
		this.mainFrame = new MainFrame(this);
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
	
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_S){
			JOptionPane.showInputDialog("Hur många lag vill ni vara?");
			
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