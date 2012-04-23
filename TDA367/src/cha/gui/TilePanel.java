package cha.gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class TilePanel extends JPanel {

	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public TilePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setPreferredSize(new Dimension(50, 50));
		setMinimumSize(new Dimension(50, 50));
		setSize(50, 50);
		setBackground(Color.RED);
		setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		panel.setBackground(Color.RED);
		add(panel,BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JPanel p1 = new JPanel();
		p1.setBackground(Color.RED);
		add(p1,BorderLayout.NORTH);
	/*	JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		p2.setBackground(Color.RED);
		p3.setBackground(Color.RED);
		p4.setBackground(Color.RED);
		
		add(p2,BorderLayout.SOUTH);
		add(p3,BorderLayout.WEST);
		add(p4,BorderLayout.EAST);*/
	}
	
	public void draw(Piece piece){
		panel.add(piece);
	}
}
