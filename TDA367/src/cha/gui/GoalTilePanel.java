package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GoalTilePanel extends TilePanel {
	
	public GoalTilePanel(){
		this.position = 0;		
		setBackground(Color.WHITE);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(panel,BorderLayout.CENTER);
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		add(p1,BorderLayout.NORTH);
		p1.add(new JLabel("Goal"));
	}
	
	@Override
	public void bet() {
		System.out.println("Goal Clicked");
		
	}
}
