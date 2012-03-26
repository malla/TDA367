package projekt;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timer extends Thread{

	public int time= getTime();
	public int getTime(){
		return 30;
	}
	
	private String timeString = Integer.toString(time);
	private JLabel seconds;
	private JPanel timerPanel;



	public static void main(String[] args){	
	Timer timer30 = new Timer();	
	}
	
	public Timer(){
		JFrame frame = new JFrame("Malla testar Timer");
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
		greenPanel.setSize(300, 300);
		frame.add(greenPanel);

		timerPanel = new JPanel();
		//timerPanel.setSize(150,150);
		timerPanel.setBackground(Color.BLACK);
		timerPanel.setOpaque(true);
		greenPanel.add(timerPanel);

	//	String timeString = Integer.toString(time());
		seconds= new JLabel("", JLabel.CENTER);
		seconds.setFont(new Font (Font.MONOSPACED,Font.BOLD,140));
		timerPanel.add(seconds);

		
	countDown(getTime());
		
	}
	
	

	
	private void countDown(int t){
		for (int i=t; i>=0; i--){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(i);
		seconds.setText(i+"");
				seconds.repaint();
		//		timerPanel.repaint();
		}
	}
	
	
	
}



