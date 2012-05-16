package cha.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import cha.event.EventBus;
import cha.event.Event;
/**
 * A class which creates a timer.
 * @author Malla
 */

public class CountDown implements ActionListener{
	private Timer timer;
	private int count;

	public CountDown(){
		count = 30;
		timer = new Timer(1000, this);
		timer.start();
	}
	/*	public static void main(String[] args){
		CountDown tt= new CountDown();
		while(true){
			;
		}
	}
	 */
	private void ticktock(){
		EventBus.getInstance().publish(Event.TimeTick, Integer.toString(count));
		if (count==-1){
			timer.stop();
			EventBus.getInstance().publish(Event.TimeOver, null);
		}
		System.out.println(count--);
		

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ticktock();
	}
	
	public void stopTimer(){
		timer.stop();
	}
}