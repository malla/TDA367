package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import projekt.ChallengeAccepted;

import java.awt.FlowLayout;
import java.awt.Dimension;

public class MainFrame {

	private JFrame frmChallengeAccepted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame(null);
					window.frmChallengeAccepted.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private TileContainerPanel tileContainerPanel = new TileContainerPanel();
	
	public MainFrame(ChallengeAccepted controller) {
		initialize();
		frmChallengeAccepted.addKeyListener(controller);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChallengeAccepted = new JFrame();
		frmChallengeAccepted.setTitle("Challange Accepted");
		frmChallengeAccepted.setResizable(false);
		frmChallengeAccepted.setBounds(100, 100, 710, 530);
		frmChallengeAccepted.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmChallengeAccepted.getContentPane().add(tileContainerPanel, BorderLayout.CENTER);
		
		TextPanel textPanel = new TextPanel();
		tileContainerPanel.add(textPanel, BorderLayout.CENTER);
	}

}