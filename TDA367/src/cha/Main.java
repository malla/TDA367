package cha;


import cha.gui.MainFrame;

public class Main {
    

    public static void main(String[] args) {
		new MainFrame();	
	}
}

/** KVAR ATT G�RA:
 *  - Ta bort on�diga System.out.print rader som anv�nts f�r kontroll. 
 *  - Om spelare st�r p� Challenge ruta, ska ha inte g�ra en bet utan 
 *  	rutan som fr�gar om opponent ska komma direkt! G�RS I BOARD!
 *  - G�ra alla spelrutor unbetable n�r Challenge.isChallengeActive()==true.
 *  - Se till att texten �ndras efter att turen g�tt �ver efter challenge.
 *  - F�rger - Tv� lag ska inte kunna vara samma f�rg.
 */