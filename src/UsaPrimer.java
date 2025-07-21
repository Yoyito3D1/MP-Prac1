import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.File;

public class UsaPrimer {
 
	public static void main(String[] args) throws FileNotFoundException {
		long startNanoTime;			// definim les variables per calcular el temps i per guardar els primers mes grans
		double[] elapsedTime;	
		String[] primerGran;
		
		Scanner teclat = new Scanner (System.in);
		
		System.out.println("Introdueix quantes linies vols llegir del fitxer (max 15): ");
		int linies = Integer.parseInt(teclat.nextLine());
				
		String[] fit = llegirFitxer(linies);			// passem a "fit" les linies llegides del fitxer
		primerGran = new String[linies];				// inicialitzem les taules per guardar els primers i el temos amb les linies
		elapsedTime = new double[linies];
		
		for (int i=0; i<fit.length; i++) {				// for per carregar els valors a la taula de PrimerGran
			if (new BigInteger(fit[i]).compareTo(new BigInteger("9223372036854775807")) == 1) {		//si el valor es més gran que el MAX LONG, utilitzme el codi amb BigInt
				startNanoTime = System.nanoTime(); 			
				primerGran[i] = Primer.primerGranBig(fit[i]);
				elapsedTime[i] = (System.nanoTime() - startNanoTime);
			}
			else {										// si es valor es mes petit, utilitzem el codi amb Long
				startNanoTime = System.nanoTime(); 		// comencem el "timer" per calcular  el primer mes gran
				primerGran[i] = Primer.PrimerGranLong(fit[i]);	
				elapsedTime[i] = (System.nanoTime() - startNanoTime); //guardem en una taula el temps transcurrit
			}			
		}
		System.out.println("Introdueix el nom del fitxer on vols guardar els valors: ");		//nom del fitxer on es vol guardar les dades
		String nomFit = teclat.nextLine();
		
		escriureFitxer(nomFit, fit, primerGran, elapsedTime);				//invoquem a la funcio per escriure en un nou fitxer les dades
		teclat.close();
		
		
	}


	public static String[] llegirFitxer (int nLinies) throws FileNotFoundException {		//metodes per llegir les linies del fitxer d'entrada
	
		if (nLinies > 15) {			// si l'usuari es passa de linies, el limit son les que hi ha al fitxer
			nLinies = 15;
		}
		if (nLinies < 1) {
			nLinies = 0;
		}
		String[] resultat = new String[nLinies];
		Scanner teclat = new Scanner (new File ("FitEntrada.txt"));		//llegim el fitxer d'entrada
	
		for (int i=0; i<nLinies; i++) {			//fem un bucle i passem cada string a una taula
			resultat[i] = teclat.nextLine();
			}
	 
		return resultat; 	//retornem la taula de strings
	
	}
	
	public static void escriureFitxer (String nomFit, String[] fitEntrada, String[] primers, double[] time) {		//metode per esciure en un fitxer de sorida ".csv" les dades que
		try {																										//es passen per parametre
			File fit = new File(nomFit+".csv");			//creem un nou fitxer que s'anomenara com l'usuari vulgui
			if (!fit.exists()) {						// comprovem si no existeix, per aixi crear-lo
				fit.createNewFile();
			}
			PrintWriter pw = new PrintWriter(fit);		//inicialitzem l'objecte per poder esciure dins del fitxer
			pw.println("Valor; Primer; Temps");			//passem una capçalera 
			
			for (int i=0; i<fitEntrada.length; i++) {	//bucle que escriura els valors d'entrada, els primers i els temps
				pw.printf("%s\t;%s\t;%.3f ms%n", fitEntrada[i], primers[i], time[i]*1.0e-6);
			}
			pw.close();
		}
		
		catch (IOException e) {
			e.getStackTrace();
		}
	}
}
