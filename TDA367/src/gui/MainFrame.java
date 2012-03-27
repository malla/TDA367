package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class MainFrame {

	private JFrame frmChallangeAccepted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmChallangeAccepted.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private TileContainerPanel tileContainerPanel = new TileContainerPanel();
	
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChallangeAccepted = new JFrame();
		frmChallangeAccepted.setTitle("Challange Accepted");
		frmChallangeAccepted.setResizable(false);
		frmChallangeAccepted.setBounds(100, 100, 710, 530);
		frmChallangeAccepted.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmChallangeAccepted.getContentPane().add(tileContainerPanel, BorderLayout.CENTER);
		
		TextPanel textPanel = new TextPanel();
		tileContainerPanel.add(textPanel, BorderLayout.CENTER);
	}

}