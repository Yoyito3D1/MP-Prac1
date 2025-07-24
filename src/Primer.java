/**
 * Classe Primer amb diferents metodes.
 * 
 * @author Jon Jordi Salvado
 *
 */
import java.math.BigInteger;

public class Primer {
	
	/**
	 * Metode per buscar el primer més gran d'un numero especific interpretat com a Long.
	 * @param valor - numero del qual es buscara el primer mes gran
	 * @return quan es trobi el primer aquest es retorna com com si fos una String
	 */
	public static String PrimerGranLong (String valor) {
		long num = Long.parseLong(valor);
	
		boolean trobat = false;
			
		long primer = -1;
		if (num >= 2) {
			if ((num == 2) || (num == 3)) {
				primer = num;
			} 
			else {
				if (num % 2 == 0) {
					num--;
				}
				long i = num;
				while (!trobat) {
					if (primerLongVerOpt(i)) {
						primer = i;
						trobat = true;
					}
					i = i - 2;
				}
				
			}
		}
		return Long.toString(primer);
	}
	/**
	 * Metode que calcular el primer mes gran d'un numero interpretat com a BigInt.
	 * @param valor - numero del qual es buscara el primer mes gran 
	 * @return quan es trobi el primer aquest es retorna com com si fos una String
	 */
	public static String primerGranBig (String valor) {
		
		BigInteger num = new BigInteger(valor);
		boolean trobat = false;
        BigInteger tres = new BigInteger("3");
		BigInteger primer = BigInteger.ZERO;
		
		if (num.compareTo(BigInteger.TWO) == 1 || num.compareTo(BigInteger.TWO) == 0) {
			if (num.equals(BigInteger.TWO) || num.equals(tres)) {
				primer = num;
			} 
			else {
				if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
					num = num.subtract(BigInteger.ONE);
				}
				BigInteger i = num;
				while (!trobat && (i.compareTo(num)==-1 || i.compareTo(num)==0)) {			
					if (PrimerBig(i)) {
						primer = i;
						trobat = true;
					}
					i = i.subtract(BigInteger.TWO);
				}
				
			}
		}
		return primer.toString();
	}
	/**
	 * Metode que calcula si el numero es primer, codi molt poc eficient
	 * @param num - numero del qual es buscara el primer mes gran 
	 * @return	true si es primer
	 */
	public static boolean primerLongVerNoOpt(long num) {
		int numDiv = 0;
		
		if (num >= 2) {
			for (long i = 1; i <= num; i++) {
				if (num % i == 0) {
					numDiv++;
				}
			}
			return (numDiv == 2);
		} 
		else {
			return false;
		}

	}
	/**
	 * Metode per comprovar si un numero es primer o no, codi molt mes eficient
	 * @param num - num del qual es comprovara si es primer
	 * @return si es primer, retorna true
	 */
	public static boolean primerLongVerOpt(long num) {

		boolean esPrimer = true;
		long maxValN = (long) Math.sqrt((double) num) + 1; 

		for (long i = 3; i <= maxValN; i = i + 2) {
			if (num % i == 0) {
					esPrimer = false;
					break;
				}
		}
		return esPrimer;
	}
	
	
	/**
	 * Metode per calcular si un BigInteger es primer
	 * @param num - numero del qual es comprovara si es primer
	 * @return true si el numero es primer
	 */
	public static boolean PrimerBig(BigInteger num) {
		boolean esPrimer = true;
        
        BigInteger tres = new BigInteger("3");
        BigInteger sqrt = num.sqrt().add(new BigInteger("1"));
        
		for(BigInteger i = tres; i.compareTo(sqrt)==-1 || i.compareTo(sqrt)==0; i = i.add(BigInteger.TWO)) { 	
			if (num.mod(i).equals(BigInteger.ZERO)) {
				esPrimer = false;
				break;
			}
		}	
        return esPrimer;
	}
}
