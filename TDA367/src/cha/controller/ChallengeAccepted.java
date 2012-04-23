package cha.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;


import javax.swing.JOptionPane;

import cha.domain.Board;
import cha.gui.MainFrame;

public class ChallengeAccepted{

	private static ChallengeAccepted instance;
//	private MainFrame mainFrame;
	private Board board;
	private List<IEventHandler> handlers = new LinkedList<IEventHandler>();

		
	private ChallengeAccepted(){
	
		board = new Board();
	//	mainFrame = new MainFrame();
	}
	
	public static ChallengeAccepted getInstance(){
		if(instance == null){
			instance = new ChallengeAccepted();
		}
		return instance;

	}
	
	public void register(IEventHandler handler){
		handlers.add(handler);
	}
	
	public void publish(Event e){
		for(IEventHandler h : handlers){
			h.action(e);
		}
	}
	
	public Board getBoard(){
		return board;
	}
}