package cha;


import cha.gui.MainFrame;

public class Main {
    

    public static void main(String[] args) {
		new MainFrame();	
	}
}

/** KVAR ATT GÖRA:
 *  - Ta bort onödiga System.out.print rader som använts för kontroll. 
 *  - Om spelare står på Challenge ruta, ska ha inte göra en bet utan 
 *  	rutan som frågar om opponent ska komma direkt! GÖRS I BOARD!
 *  - Göra alla spelrutor unbetable när Challenge.isChallengeActive()==true.
 *  - Se till att texten ändras efter att turen gått över efter challenge.
 *  - Färger - Två lag ska inte kunna vara samma färg.
 */