package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;

public class TilePanel extends JPanel {

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
	}
}
