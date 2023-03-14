package oblig3_DAT102;

import java.util.Random;

public class Oppgave2  {


// antar at de andre metodene ligger i forelesningsmapper...
// insertionSort
public static<T extends Comparable<? super T>> void sort(T[] tabell, int n) {
	sort(tabell, 0, n-1);
}

public static <T extends Comparable<? super T>> void sort(T[] tabell, int start,int slutt) {
	// TODO Auto-generated method stub


	for(int i=start+1; i<=slutt; i++) {
		T tmp = tabell[i];
		int j = i-1; // siste i sortert del
		boolean ferdig = false;


		while (!ferdig && j>=0) { // tar hensyn til at det minste skal stå fremst, altså j=0 
			if (tmp.compareTo(tabell[j])<0) {
				tabell[j+1] = tabell[j];
				j--;
			} else {
				ferdig = true;
			}

		}
		tabell[j+1]=tmp;


	}

}

//Selection Sort
private static void swap(Object[] a, int i, int j) {
	Object temp = a[i];
	a[i] = a[j];
	a[j] = temp;
}

// Utvalgssortering / Plukksortering (DAT100) (Selction sort)
// Sorterer dei f�rste n elmementa i tabellen. Kanskje litt uvanlig
// Kunne ogs� utelatt n og sortert heile tabellen.

public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
	for (int i = 0; i < n - 1; i++) {
		int minstePos = finnMinstePos(a, i, n - 1);
		swap(a, i, minstePos);
	}
}

private static <T extends Comparable<? super T>> int finnMinstePos(T[] a, int fra, int til) {
	int p = fra;
	for (int i = fra + 1; i <= til; i++) {
		if (a[i].compareTo(a[p]) < 0) {
			p = i;
		}
	}

	return p;
}
//Quick sort



public static final int MIN_SIZE = 5;

public static <T extends Comparable<? super T>> void quickSort(T[] array, int n) {
	kvikksorter(array, 0, n - 1);
	
	// gjer sorteringa ferdig
	sort(array,  n);
}

// grovsorterer
public static <T extends Comparable<? super T>> void kvikksorter(T[] a, int forste, int siste) {
	if (siste - forste + 1 > MIN_SIZE) {
		int delepkt = partition(a, forste, siste);
		kvikksorter(a, forste, delepkt - 1);
		kvikksorter(a, delepkt +1, siste);
	} // else basis: gjer ingenting
} 

// Partitions an array as part of quick sort into two subarrays
// called Smaller and Larger that are separated by a single
// entry called the pivot.
// Entries in Smaller are <= pivot and appear before the
// pivot in the array.
// Entries in Larger are >= pivot and appear after the
// pivot in the array.
// Parameters:
// a An array of Comparable objects.
// first The integer index of the first array entry;
// first >= 0 and < a.length.
// last The integer index of the last array entry;
// last - first >= 3; last < a.length.
// Returns the index of the pivot.
private static <T extends Comparable<? super T>> int partition(T[] a, int forste, int siste) {
	int midten = (forste + siste) / 2;

	// Ordnar f�rste, midterse og siste element slik at dei st�r rett i forhold til kvarandre
	sortFirstMiddleLast(a, forste, midten, siste);


	// Flyttar pivot til nest siste plass
	swap(a, midten, siste - 1);
	int pivotIndex = siste - 1;
	T pivotValue = a[pivotIndex];

	// Finn f�rste i venstre del som er mindre st�rre enn pivot
	// siste i h�gre del som er mindre enn pivot

	int fraVenstre = forste + 1;
	int fraHogre = siste - 2;

	boolean ferdig = false;
	while (!ferdig) {
		
		while (a[fraVenstre].compareTo(pivotValue) < 0) {
			fraVenstre++;
		}
		
		while (a[fraHogre].compareTo(pivotValue) > 0) {
			fraHogre--;
		}
		
		if (fraVenstre < fraHogre) {
			swap(a, fraVenstre, fraHogre);
			fraVenstre++;
			fraHogre--;
		} else
			ferdig = true;
	} 

	// Place pivotValue between the subarrays Smaller and Larger
	swap(a, pivotIndex, fraVenstre);
	pivotIndex = fraVenstre;

	return pivotIndex;
} 

// Sorts the first, middle, and last entries of an array into ascending order.
// Parameters:
// a An array of Comparable objects.
// first The integer index of the first array entry;
// first >= 0 and < a.length.
// mid The integer index of the middle array entry.
// last The integer index of the last array entry;
// last - first >= 2, last < a.length.
private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
	order(a, first, mid); // Make a[first] <= a[mid]
	order(a, mid, last); // Make a[mid] <= a[last]
	order(a, first, mid); // Make a[first] <= a[mid]
} // end sortFirstMiddleLast

// Orders two given array elements into ascending order
// so that a[i] <= a[j].
private static <T extends Comparable<? super T>> void order(T[] a, int i, int j) {
	if (a[i].compareTo(a[j]) > 0)
		swap(a, i, j);
} // end order





//Merge sort
public static <T extends Comparable<? super T>> void flettesortering(T[] a, int n) {
	flettesortering(a, 0, n - 1);
}

public static <T extends Comparable<? super T>> void flettesortering(T[] a, int first, int last) {
	// The cast is safe because the new array contains null entries
	@SuppressWarnings("unchecked")
	T[] tempArray = (T[]) new Comparable<?>[a.length]; // unchecked cast
	flettesortering(a, tempArray, first, last);
}

private static <T extends Comparable<? super T>> void flettesortering(T[] a, T[] tempTab, int forste, int siste) {
	if (forste >= siste) {
		// basis: gjer ingenting
		// Dette er eit triks for � vise at vi har tenkt p� basistilfelle.
		// Kunne i staden utelate dette og teste om forste < siste og s� g�tt rett p� delen i else-blokka
	} else {
		int midtpkt = (forste + siste) / 2;
		flettesortering(a, tempTab, forste, midtpkt);
		flettesortering(a, tempTab, midtpkt + 1, siste);
		flette(a, tempTab, forste, midtpkt, siste);			
	}
}

private static <T extends Comparable<? super T>> void flette(T[] a, T[] tempTab, int forste, int midten,
		int siste) {
	// Flettar saman to deler som ligg ved sida av kvaranre
	// forste, ..., midten og midten + 1, ..., siste
	int fV = forste;
	int sluttV = midten;
	int fH = midten + 1;
	int sluttH = siste;

	// S� lenge det er element att i begge delane, flytt over den minste til tempTab
	int index = fV; // Next available location in tempArray
	for (; (fV <= sluttV) && (fH <= sluttH); index++) {
		if (a[fV].compareTo(a[fH]) < 0) {
			tempTab[index] = a[fV];
			fV++;
		} else {
			tempTab[index] = a[fH];
			fH++;
		}
	}

	// No vil ein av delane vere to. Kopierer over resten i den andr eedelen

	// Venstre del, kan vere tom
	for (; fV <= sluttV; fV++, index++) {
		tempTab[index] = a[fV];
	}

	// H�gre del, kan vere tom
	for (; fH <= sluttH; fH++, index++) {
		tempTab[index] = a[fH];
	}

	// Kopier den sorterte delen tilbake
	for (index = forste; index <= siste; index++) {
		a[index] = tempTab[index];
	}
}




}