package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GoalTilePanel extends TilePanel {
	private static final int GOAL_POSITION = 43;

	public GoalTilePanel(){
		this.position = GOAL_POSITION;		
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
}
