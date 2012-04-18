package cha.gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import cha.controller.ChallengeAccepted;

@SuppressWarnings("serial")
public class TilePanel extends JPanel {

	JPanel panel;
	int position;

	public TilePanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setPreferredSize(new Dimension(50, 50));
		setMinimumSize(new Dimension(50, 50));
		setSize(50, 50);
		setLayout(new BorderLayout(0, 0));
		
		this.addMouseListener(new MouseListener());
	/*	JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		p2.setBackground(color);
		p3.setBackground(color);
		p4.setBackground(color);
		
		add(p2,BorderLayout.SOUTH);
		add(p3,BorderLayout.WEST);
		add(p4,BorderLayout.EAST);*/
	}
	
	public void addPiece(PiecePanel piece){
		panel.add(piece);
	}
	
	public void removePiece(PiecePanel piece){
		panel.remove(piece);
	}
	
	public void showbet(){
		this.setBorder(new LineBorder(Color.BLACK, 2));
	}
	
	class MouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			int teamPosition = ChallengeAccepted.getInstance().getBoard().getActivePiece().getPosition();
			if(teamPosition < position && teamPosition + 7 >= position){
				ChallengeAccepted.getInstance().getBoard().getActivePiece().bet(position - teamPosition);
			}
		}
	}
}