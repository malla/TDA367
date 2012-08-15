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
 *  	rutan som frågar om opponent ska komma direkt!
 *  - Göra alla spelrutor unbetable när Challenge.isChallengeActive()==true.
 *  - Se till att spelpjäserna rör på sig som de ska efter en challenge.
 *  - Se till att turen går över till nästa spelare efter en challenge.
 */