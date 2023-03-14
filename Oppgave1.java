package oblig3_DAT102;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Oppgave1 {

	// må han en måte å starte likt.
	public static Integer[] genTab() {
		long start = 0;
		Random tilfeldig = new Random(start);
		int n = 100_000;

		Integer[] tabell = new Integer[n];

		// sette inn i tabellen
		for (int i = 0; i < n; i++) {
			tabell[i] = tilfeldig.nextInt();

		}
		return tabell;
	}

	public static <T extends Comparable<? super T>> void sort(T[] tabell, int n) {
		sort(tabell, 0, n - 1);
	}

	public static <T extends Comparable<? super T>> void sort(T[] tabell, int start, int slutt) {
		// TODO Auto-generated method stub

		for (int i = start + 1; i <= slutt; i++) {
			T tmp = tabell[i];
			int j = i - 1;
			boolean ferdig = false;

			while (!ferdig && j >= 0) { 
				if (tmp.compareTo(tabell[j]) < 0) {
					tabell[j + 1] = tabell[j];
					j--;
				} else {
					ferdig = true;
				}

			}
			tabell[j + 1] = tmp;

		}

	}

	public static <T extends Comparable<? super T>> void sortMinsteForst(T[] a) {
		int n = a.length;

		for (int i = n - 1; i > 0; i--) { // n-1 er slutten-1, løkken går fra høyre til venstre
			if (a[i].compareTo(a[i - 1]) < 0) { // sjekker om objektet til høyre er mindre enn det til venstre
				T tmp = a[i];// tmp holder objektet til høyre
				a[i] = a[i - 1]; // setter objektet til høyre ned en indeks
				a[i - 1] = tmp; // setter objektet til venstre opp en indeks
				// gjentar helt til det bare i = 1
			}
		}
//ser ikke hvorfor sorteringen begynner her og ikke over
		for (int i = 2; i < n; i++) { // begynner med indeks 2, siden 0 og 1 er sortert
			T tmp = a[i]; // tmp holder objektet vi peker på
			int j = i - 1; // siste i sortert del av tabell, indeks 1

			while (tmp.compareTo(a[j]) < 0) { // så lenge objektet vi peker på er mindre enn siste del i sortert tabell
				a[j + 1] = a[j]; // setter det første objektet i usortert tabell til det siste i sortert del
				j--; // j minsker med en
			}

			a[j + 1] = tmp; // holder verdien til neste objekt i usortert del
		}
	}

	public static <T extends Comparable<? super T>> void sortTo(T[] a) {
		int n = a.length;
		// samme som over, flytter det minste og passer på at to like elementer ikke
		// bytter plass
		for (int i = n - 1; i > 0; i--) {
			if (a[i].compareTo(a[i - 1]) < 0) {
				T tmp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = tmp;
			}
		}

		// Dersom n er odde har blir det par av dei andre. Om n er jevn
		// startar vi i posisjon for at det skal bli par av resten

		int start = (n % 2 == 1 ? 1 : 2); // Kunne brukt if

		for (int i = start; i < n; i += 2) {

			T minst = null;
			T storst = null;

			if (a[i].compareTo(a[i + 1]) <= 0) {
				minst = a[i];
				storst = a[i + 1];
			} else {
				minst = a[i + 1];
				storst = a[i];
			}

			int j = i - 1; // siste i sortert del

			while (storst.compareTo(a[j]) < 0) {
				a[j + 2] = a[j];
				j--;
			}

			a[j + 2] = storst;

			while (minst.compareTo(a[j]) < 0) {
				a[j + 1] = a[j];
				j--;
			}

			a[j + 1] = minst;
		}
	}

	public static void TestAlle() {
		// kan genere tabellen utenfor løkken når jeg har flere metoder å sammneligne,
		// så bruker de samme tabellen.
		// eller finne ut hvordan den kan generere en lik tabell hver gang

		int forsøk = 0;
		long totalTid1 = 0;
		long totalTid2 = 0;
		long totalTid3 = 0;

		// en løkke for alle,
		while (forsøk < 10) {
			Integer[] tab = genTab();
			Integer[] tab1 = tab.clone();
			Integer[] tab2 = tab.clone();
			Integer[] tab3 = tab.clone();

			long start = System.nanoTime();
			sort(tab1, tab1.length);
			long finish = System.nanoTime();
			long tid1 = finish - start;
			totalTid1 = totalTid1 + tid1;

			// a, minst forst
			start = System.nanoTime();
			sortMinsteForst(tab2);
			finish = System.nanoTime();
			long tid2 = finish - start;
			totalTid2 = totalTid2 + tid2;

			// b, to forste
			start = System.nanoTime();
			sortTo(tab3);
			finish = System.nanoTime();
			long tid3 = finish - start;
			totalTid3 = totalTid3 + tid3;

			forsøk++;

		}
		// snitt
		double tidSekund1 = (double) totalTid1 / 1_000_000_000;
		double snitt1 = tidSekund1 / forsøk;

		double tidSekund2 = (double) totalTid2 / 1_000_000_000;
		double snitt2 = tidSekund2 / forsøk;

		double tidSekund3 = (double) totalTid3 / 1_000_000_000;
		double snitt3 = tidSekund3 / forsøk;

		System.out.println("Gjennomsnittstiden for insertion sort er: " + snitt1 + " sekunder ");
		System.out.println("Gjennomsnittstiden for minst først er: " + snitt2 + " sekunder ");
		System.out.println("Gjennomsnittstiden sett inn 2 omgangen er: " + snitt3 + " sekunder ");

		/**
		 * resultatene viser at den mest effektive metoden er å sette den minste først
		 * med en gang er litt raskere enn å sette to inn først Begge er mye raskere enn
		 * å bare sortere ved innsetting.
		 */
	}

}
