package cha.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;


import javax.swing.JOptionPane;

import cha.domain.Board;
import cha.gui.MainFrame;

public class ChallengeAccepted{

	private static ChallengeAccepted CHinstance = null;
//	private MainFrame mainFrame;
	private static Board board;
	private List<IEventHandler> handlers = new LinkedList<IEventHandler>();

		
	private ChallengeAccepted(){
	//	mainFrame = new MainFrame();
	}
	
	public static ChallengeAccepted getInstance(){
		if(CHinstance == null){
			CHinstance = new ChallengeAccepted();
		}
		return CHinstance;
	}
	
	public void createBoard(){
		board = Board.getInstance();
	}
	
	public Board getBoard(){
		return board;
	}
	
	public void register(IEventHandler handler){
		handlers.add(handler);
	}
	
	public void publish(Event e, Object o){
		for(IEventHandler h : handlers){
			h.action(e, o);
		}
	}
}