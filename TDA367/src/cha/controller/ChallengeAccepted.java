package cha.controller;


import java.util.LinkedList;
import java.util.List;

import cha.domain.Board;

public class ChallengeAccepted{

	private static ChallengeAccepted CHinstance = null;
	private List<IEventHandler> handlers = new LinkedList<IEventHandler>();

		
	private ChallengeAccepted(){
	}
	
	public static ChallengeAccepted getInstance(){
		if(CHinstance == null){
			CHinstance = new ChallengeAccepted();
		}
		return CHinstance;
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