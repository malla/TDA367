package cha;


import cha.gui.MainFrame;

public class Main {
    

    public static void main(String[] args) {
		new MainFrame();	
	}
}

/** KVAR ATT G�RA:
 *  - Ta bort on�diga System.out.print rader som anv�nts f�r kontroll. 
 *  - Se till att texten �ndras efter att turen g�tt �ver efter challenge.
 *  - F�rger - Tv� lag ska inte kunna vara samma f�rg.
 *  - Piece hoppar av sig sj�lv n�r n�gon st�r p� en Challenge-tile
 *  - Den repaintar inte efter en Challenge innan det blir ny Challenge tur.
 */