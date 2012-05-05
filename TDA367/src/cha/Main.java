//package projekt;
//
//public class Main {
//	public static void main (String [] args){
//		
//		
//		
//		new ChallengeAccepted();
//	}
//}
package cha;

import java.util.Scanner;

import cha.domain.Bet;
import cha.domain.Board;



public class Main {

    public void run() {
        // Monopoly mply = Monopoly.getInstance();
    	Board newBoard = Board.getInstance();
    	
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            String line = in.nextLine();
            if (line.equals("b")) {  // Bet
            	System.out.println("Make bet: ");
            	String value = in.nextLine();
            	
            	newBoard.getActivePiece().setBet(Integer.parseInt(value));
            	System.out.println(newBoard.getActivePiece());
            	
            } else if (line.equals("s")) {  // Start Mission  
            	newBoard.beginMission(null);
            	System.out.println(newBoard.getMission().toString());
                
            } else {

            }  
        }
    }

  
    public static void main(String[] args) {
        new Main().run();
    }
}