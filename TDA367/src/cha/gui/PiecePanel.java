package cha.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PiecePanel extends JPanel {
	
	public final Color color;
	public final Dimension size = new Dimension(12,12);
	
	public PiecePanel(Color c){
		setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		color = c;
		initialize();
	}
	
	private void initialize(){
		this.setBackground(color);
		//this.setForeground(color);
		this.setSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
	}
}
