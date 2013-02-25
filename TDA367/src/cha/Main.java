package cha;


import cha.gui.MainFrame;

public class Main {
    

    public static void main(String[] args) {
		new MainFrame();	
	}
}

/** KVAR ATT GÖRA:
 *  - Ta bort onödiga System.out.print rader som använts för kontroll. 
 *  - Se till att texten ändras efter att turen gått över efter challenge.
 *  - Färger - Två lag ska inte kunna vara samma färg.
 *  - Piece hoppar av sig själv när någon står på en Challenge-tile
 *  - Den repaintar inte efter en Challenge innan det blir ny Challenge tur.
 */