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
 *
 *	Johan:
 *	Mission/challenge UC	//DONE
 *	challenge p� challenge	//DONE
 *	combobox (vid nytt spel)//DONE
 *
 *	Malla:
 *	G� i m�l				//DONE
 *	R�tt knappar			//DONE
 *	R�tt text				//DONE
 *	Flytta pj�ser			//DONE
 *	Nytt spel				//DONE
 *	Rules knappar			//DONE	
 *
 *Malla 6e april:
 *comboboxen vid challenge visar fel namn.
 *
 *Johan 18 april
 *Cleanup i challenge och mission 	//DONE
 *Tar �ven board 	//DONE
 *Gick igenom resten av domain och tog bort oanv�nd kod, �ndra visibility och tog bort static
 *
 *Bella 4 maj
 *G�r igenom gui och tar bort on�dig kod samt printlines
 *
 */