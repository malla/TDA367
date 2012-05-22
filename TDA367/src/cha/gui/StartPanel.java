//package cha.gui;
//
//
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.LayoutManager;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import cha.event.EventBus;
//import cha.event.Event;
//
//@SuppressWarnings("serial")
//public class StartPanel extends JPanel implements ActionListener {
//	
//	JButton startButton;
//	JButton rulesButton;
//	JLabel background;
//	
//	public StartPanel() {
//		this.setLayout(new FlowLayout());
//		setBackground(Color.BLUE);
//		
//		ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\Isabelle\\Documents\\IT\\TDA367\\ProjektIT12\\ChallengeAccepted.png").getImage());  
//		  
//	    
//		
//		startButton = new JButton("New Game");
//		rulesButton = new JButton("Rules");
//		
//		startButton.addActionListener(this);
//		rulesButton.addActionListener(this);
//		
//		this.add(startButton);
//		this.add(rulesButton);
//	
//		
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == startButton){
//			EventBus.getInstance().publish(Event.NewGame, null);
//		}else if(e.getSource() == rulesButton){
//			EventBus.getInstance().publish(Event.ShowGameRules, null);
//		}	
//	}
//}
