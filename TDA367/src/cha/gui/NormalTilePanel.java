package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NormalTilePanel extends TilePanel {
	
	public NormalTilePanel(Color color, int position){
		this.position = position;		
		setBackground(color);
		panel = new JPanel();
		panel.setBackground(color);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(panel,BorderLayout.CENTER);
		JPanel p1 = new JPanel();
		p1.setBackground(color);
		add(p1,BorderLayout.NORTH);
		p1.add(new JLabel(Integer.toString(position)));
	}

}
