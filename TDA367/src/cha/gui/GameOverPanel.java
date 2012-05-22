package cha.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import cha.domain.Team;

@SuppressWarnings("serial")
public class GameOverPanel extends JPanel {
	
	private JLabel teamColorIcon;
	private JLabel teamLabel;

	public GameOverPanel() {
		setBackground(Color.WHITE);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = GridBagConstraints.REMAINDER;
		
		JLabel winnerIsLabel = new JLabel("And the winner is:");
		Font winnerIsLabelFont = winnerIsLabel.getFont();
		winnerIsLabel.setFont(new Font(winnerIsLabelFont.getName(), 
				winnerIsLabelFont.getStyle(), 48));
		this.add(winnerIsLabel, c);
		
		teamColorIcon = new JLabel();
		teamColorIcon.setOpaque(true);
		Dimension size = new Dimension(32, 32);
		teamColorIcon.setMinimumSize(size);
		teamColorIcon.setMaximumSize(size);
		teamColorIcon.setPreferredSize(size);
		teamColorIcon.setBackground(Color.RED);
		teamColorIcon.setBorder(new LineBorder(Color.BLACK, 3));

		c.gridwidth = 1;		
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		c.insets = new Insets(0, 0, 0, 32);
		this.add(teamColorIcon, c);
		
		teamLabel = new JLabel("T");
		Font teamLabelFont = teamLabel.getFont();
		teamLabel.setFont(new Font(teamLabelFont.getName(), teamLabelFont.getStyle(), 42));
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.WEST;
		this.add(teamLabel, c);
		
	}
	
	public void setWinnerTeam(Team winningTeam) {
		teamLabel.setText(winningTeam.getName());
		teamColorIcon.setBackground(winningTeam.getColor());
	}
}
