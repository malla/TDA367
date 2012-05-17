package cha.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.domain.Board;
import cha.event.Event;
import cha.event.EventBus;
import cha.event.IEventHandler;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel implements IEventHandler {

	private JLabel player;
	public PlayerPanel(){
		EventBus.getInstance().register(this);
		player = new JLabel();
		this.add(player);
	}
	@Override
	public void action(Event e, Object o) {
		if(e == Event.NextPlayer){
			player.setText(Board.getInstance().getActivePiece().getTeam().getName());
			this.repaint();
		}
		
	}

}
