package cha;


import cha.gui.MainFrame;

public class Main {
    

    public static void main(String[] args) {
		new MainFrame();	
	}
}

/** KVAR ATT G�RA:
 *  - Ta bort on�diga System.out.print rader som anv�nts f�r kontroll. 
 *  - G�ra alla spelrutor unbetable n�r Challenge.isChallengeActive()==true.
 *  - Se till att texten �ndras efter att turen g�tt �ver efter challenge.
 *  - F�rger - Tv� lag ska inte kunna vara samma f�rg.
<<<<<<< HEAD
 *  - Piece hoppar av sig sj�lv n�r n�gon st�r p� en Challenge-tile
=======
 *  - Den repaintar inte efter en Challenge innan det blir ny Challenge tur.
>>>>>>> 1f1ed4dca70bd59f201bdc968ea0c3600b271497
 */