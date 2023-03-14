package oblig3_DAT102;

public class Main extends Oppgave1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Integer [] tab = genTab();
		Integer [] tab1 = tab.clone();
		Integer [] tab2 = tab.clone();
		Integer [] tab3 = tab.clone();

//problemet mitt er at den første sorteringen gjør at alle tabellene er sortert... 
		// det e åpenbart, for de andre peker bare på tab...
		
		
		
		
		
	/*	
		long start=System.nanoTime();
		sort(tab1,tab1.length);
		long finish=System.nanoTime();
		long tid = finish-start;
		double sekund = (double)tid/1_000_000_000;
		System.out.println(sekund); 
		
		long start1=System.nanoTime();
		sortMinsteForst(tab2);
		long finish1=System.nanoTime();
		long tid1 = finish1-start1;
		double sekund1 = (double)tid1/1_000_000_000;
		System.out.println(sekund1);
		
	 
		
		long start2=System.nanoTime();
		sortTo(tab3);
		long finish2=System.nanoTime();
		long tid2 = finish2-start2;
		double sekund2 = (double)tid2/1_000_000_000;
		System.out.println(sekund2); 
	*/
		TestAlle();
		
	}
}


