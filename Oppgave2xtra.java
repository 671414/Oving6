package oblig3_DAT102;

import java.util.Random;

public class Oppgave2xtra extends Oppgave2{

	
/*
 * 
 * Insertion sort
 * 
 * 
 */
	
public static void InsertSortTimeNy(int n, int forsøk) { // ny tabell for hver gjennomføring, lager en med medtode til med samme tabell
	// alle tabeller som skal sorteres

	
	// løkke for å regne gjennomsnittsti
	int fk=0;
	long totalTime=0;
	
	while (fk <=forsøk) {
		Integer [] tab=genTabValg(n);
	long start = System.nanoTime();		
		sort(tab,tab.length);
	long finish = System.nanoTime();
	long Time = finish-start;
		totalTime = totalTime + Time;
		fk++;
	}
	
	//gjennomsnitt
	double SecSort = (double)totalTime/1_000_000_000;
	double snitt = SecSort/fk;
// noe feil er det siden snitt bare printer 0.0
	String resultater = "[" + n + " | " + fk + " | " + snitt  +"|" + " Teoretisk tid " + "]" + "\n " ;
						// må bare ta den teoretisk tiden og implementere for alle sorteringene. 
	
	System.out.print(resultater);
}

public static void InsertSortTime(int n) { 
	// alle tabeller som skal sorteres
	Integer [] tab=genTabValg(n);
//vil jo ende opp med at den er sortert på de andre forsøkene
	
	// løkke for å regne gjennomsnittstid
	int forsøk=0;
	long totalTime=0;
	
	while (forsøk <=10) {
	long start = System.nanoTime();		
		sort(tab,tab.length);
	long finish = System.nanoTime();
	long Time = finish-start;
		totalTime = totalTime + Time;
		forsøk++;
	}
	
	//gjennomsnitt
	double SecSort = (double)totalTime/1_000_000_000;
	double snitt = SecSort/forsøk;

	String resultater = "[" + n + " | " + forsøk + " | " + snitt  +"|" + " Teoretisk tid " + "]" + "\n " ;
						
	
	System.out.print(resultater);
}

/*
 * 
 * 
 * quicksort
 * 
 * 
 */
public static void QuicSortTimeNy(int n) { 
	
	int forsøk=0;
	long totalTime=0;
	
	while (forsøk <=10) {
		Integer [] tab=genTabValg(n);
	long start = System.nanoTime();		
	quickSort(tab, tab.length);
	long finish = System.nanoTime();
	long Time = finish-start;
		totalTime = totalTime + Time;
		forsøk++;
	}
	
	//gjennomsnitt
	double SecSort = (double)totalTime/1_000_000_000;
	double snitt = SecSort/forsøk;

	String resultater = "[" + n + " | " + forsøk + " | " + snitt  +"|" + " Teoretisk tid " + "]" + "\n " ;
						
	
	System.out.print(resultater);
}

public static void quickSortTime(int n) { 
	// alle tabeller som skal sorteres
	Integer [] tab=genTabValg(n);
//vil jo ende opp med at den er sortert på de andre forsøkene
	
	// løkke for å regne gjennomsnittstid
	int forsøk=0;
	long totalTime=0;
	
	while (forsøk <=10) {
	long start = System.nanoTime();		
	sort(tab,tab.length);
	long finish = System.nanoTime();
	long Time = finish-start;
		totalTime = totalTime + Time;
		forsøk++;
	}
	
	//gjennomsnitt
	double SecSort = (double)totalTime/1_000_000_000;
	double snitt = SecSort/forsøk;

	String resultater = "[" + n + " | " + forsøk + " | " + snitt  +"|" + " Teoretisk tid " + "]" + "\n " ;
						
	
	System.out.print(resultater);
}

/*
 * 
 * 
 * Flettesortering
 * 
 * 
 */

public static Integer[] genTabValg(int n) {
		long start =0;
		Random tilfeldig = new Random(start);
		 


		Integer [] tabell = new Integer[n];

		//sette inn i tabellen
		for (int j=0; j<n; j++) {
			tabell[j] = tilfeldig.nextInt();

		}
		return tabell;
	}


public static Integer[] genTab() {
		long start =0;
		Random tilfeldig = new Random(start);
		int n = 100_000;


		Integer [] tabell = new Integer[n];

		//sette inn i tabellen
		for (int i=0; i<n; i++) {
			tabell[i] = tilfeldig.nextInt();

		}
		return tabell;
	}
}
