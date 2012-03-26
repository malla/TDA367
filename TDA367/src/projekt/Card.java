package projekt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Card {
	public static void main(String[] args){	
		Card card = new Card();	
		}
		
		public Card(){
			JFrame frame = new JFrame("Malla testar kort");
			frame.setSize(400, 400);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//JButton button = new JButton("Tryck!");
			//button.setSize(40, 50);
			//frame.add(button);
		//}
			//public void skapa(){
			JPanel greenPanel = new JPanel();
			greenPanel.setBackground(Color.green);
			greenPanel.setPreferredSize(new Dimension(300, 300));
			frame.add(greenPanel);

			JPanel cardPanel = new JPanel();
			cardPanel.setPreferredSize(new Dimension(200, 100));

			cardPanel.setBackground(Color.white);
			greenPanel.add(cardPanel);
			
		}
}
