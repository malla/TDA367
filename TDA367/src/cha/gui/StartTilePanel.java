package cha.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cha.domain.Categories.Category;

@SuppressWarnings("serial")
public class StartTilePanel extends TilePanel {
	
	private JPanel p1; StartTilePanel(Category c){
		position = 0;
		panel = new JPanel();
		p1 = new JPanel();
		setColor(c);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(panel,BorderLayout.CENTER);
		add(p1,BorderLayout.NORTH);
		p1.add(new JLabel("Start"));
	}
	
	private void setColor(Category c){
		if(c == Category.BACKWARDS){
			this.setBackground(Color.RED);
			panel.setBackground(Color.RED);
			p1.setBackground(Color.RED);
		}
		else if(c == Category.BODYTOBODY){
			this.setBackground(Color.YELLOW);
			panel.setBackground(Color.YELLOW);
			p1.setBackground(Color.YELLOW);
		}
		else if(c == Category.SAMECLASS){
			this.setBackground(Color.BLUE);
			panel.setBackground(Color.BLUE);
			p1.setBackground(Color.BLUE);
		}
		else{
			this.setBackground(Color.GREEN);
			panel.setBackground(Color.GREEN);
			p1.setBackground(Color.GREEN);
		}
	}
}