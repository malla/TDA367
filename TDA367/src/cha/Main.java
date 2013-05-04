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
 *
 *	Johan:
 *	Mission/challenge UC	//DONE
 *	challenge på challenge	//DONE
 *	combobox (vid nytt spel)//DONE
 *
 *	Malla:
 *	Gå i mål				//DONE
 *	Rätt knappar			//DONE
 *	Rätt text				//DONE
 *	Flytta pjäser			//DONE
 *	Nytt spel				//DONE
 *	Rules knappar			//DONE	
 *
 *Malla 6e april:
 *comboboxen vid challenge visar fel namn.
 *
 *Johan 18 april
 *Cleanup i challenge och mission 	//DONE
 *Tar även board 	//DONE
 *Gick igenom resten av domain och tog bort oanvänd kod, ändra visibility och tog bort static
 *
 *Bella 4 maj
 *Går igenom gui och tar bort onödig kod samt printlines
 *
 */