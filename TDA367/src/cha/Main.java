package cha;


import cha.gui.MainFrame;

public class Main {
    

    public static void main(String[] args) {
		new MainFrame();	
	}
}

/** KVAR ATT G�RA:
 *  - Ta bort on�diga System.out.print rader som anv�nts f�r kontroll. 
 *  - Fixa back knappen i regler menyn. 
 *  TESTER
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
 *Vi har v�ldigt lite kommentarer 
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
 *G�r igenom gui och tar bort on�dig kod samt printlines //DONE
 *
 * Bella - SDD inklusive STAN och DesignModel
 * Johan - UseCase, Classdiagram och UseCaseMap
 * Malla - RAD 
 *
 * RAD, UseCases och UseCaseMap (Kolla hur m�nga useCases som beh�vs)
 *
 */