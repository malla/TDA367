package cha.gui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import cha.domain.Piece;

@SuppressWarnings("serial")
public class PiecePanel extends JPanel {
	
	public final Color color;
	public final Dimension size = new Dimension(12,12);
	
	public PiecePanel(Piece piece, Color c){
		setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		color = c;
		initialize();
	}
	
	private void initialize(){
		this.setBackground(color);
		this.setSize(size);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setVisible(true);
	}
	
}
