import java.util.Scanner;

public class Main {
	private static TupelSportarten ballett;
	private static TupelSportarten modernDance;
	private static TupelSportarten hiphop;
		
	//Ballsportarten
	private static TupelSportarten fussball;
	private static TupelSportarten volleyball;
	private static TupelSportarten tennis; 
		
	//Kampfsportarten
	private static TupelSportarten judo;
	private static TupelSportarten boxen;
	private static TupelSportarten karate;
		
	//Fitness
	private static TupelSportarten fitnessstudio;
	private static TupelSportarten pilates;
	private static TupelSportarten laufen;
		
	//reiten
	private static TupelSportarten dressur;
	private static TupelSportarten springen;
	private static TupelSportarten vielseitigkeit;
	
	//Wassersport
	private static TupelSportarten schwimmen;
	private static TupelSportarten tauchen;
	private static TupelSportarten kanuFahren;
	
	private static Testantwort antwortA;
	private static Testantwort antwortB;
	private static Testantwort antwortC;
	private static Testantwort antwortD;
	private static Testantwort antwortE;
	

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		// Tanzen
		ballett = new TupelSportarten("Ballett", 0);
		modernDance = new TupelSportarten("Modern Dancee", 0);
		hiphop = new TupelSportarten("Hiphop", 0);
		
		//Ballsportarten
		fussball = new TupelSportarten("Fußball", 0);
		volleyball = new TupelSportarten("Volleyball", 0);
		tennis = new TupelSportarten("Tennis", 0);
		
		//Kampfsportarten
		judo = new TupelSportarten("Judo", 0);
		boxen = new TupelSportarten("boxen", 0);
		karate = new TupelSportarten("Karate", 0);
		
		//Fitness
		fitnessstudio = new TupelSportarten("Fitnessstudio", 0);
		pilates = new TupelSportarten("Pilates", 0);
		laufen = new TupelSportarten("Laufen", 0);
		
		//Reiten
		dressur = new TupelSportarten("Dressur Reiten", 0);
		springen = new TupelSportarten("Stringreiten", 0);
		vielseitigkeit = new TupelSportarten("Vielseitigkeis Reiten", 0);
		
		//Wassersport
		schwimmen = new TupelSportarten("Dressur Reiten", 0);
		kanuFahren = new TupelSportarten("Stringreiten", 0);
		tauchen = new TupelSportarten("Vielseitigkeis Reiten", 0);
		
		//Antworten 
		antwortA = new Testantwort("a", "stimme ich zu");
		antwortB = new Testantwort("b", "stimme ich eher zu");
		antwortC = new Testantwort("c", "neutral");
		antwortD = new Testantwort("d", "stimme ich eher nicht zu");
		antwortE = new Testantwort("e", "stimme ich nicht zu");
		
		Testfrage frage1 = new Testfrage(1, "Frage");
		
		System.out.println("Bitte beantworten Sie nächsten Thesen und Fragen wahrheitsgemäß:");
		System.out.println(frage1.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
		
		String meineAntwort = in.next();

		if(meineAntwort.equals(antwortA.getKennzeichnung())) {
			ballett.plus2();
			modernDance.plus2();
			hiphop.plus2();
			fitnessstudio.plus2();
			judo.plus2();
			boxen.plus2();
			karate.plus2();
			volleyball.plus2();
			schwimmen.plus2();	
		}
		else if (meineAntwort.equals(antwortB.getKennzeichnung())) {
			modernDance.plus1();
			hiphop.plus1();
			fitnessstudio.plus1();
			judo.plus1();
			boxen.plus1();
			karate.plus1();
			volleyball.plus1();
			schwimmen.plus1();
		}
		
		else if (meineAntwort.equals(antwortC.getKennzeichnung())) {
		}
			
		else if (meineAntwort.equals(antwortD.getKennzeichnung())) {
			ballett.minus1();
			modernDance.minus1();
			hiphop.minus1();
			fitnessstudio.minus1();
			judo.minus1();
			boxen.minus1();
			karate.minus1();
			volleyball.minus1();
			schwimmen.minus1();
		}
		else if (meineAntwort.equals(antwortE.getKennzeichnung())) {
			ballett.minus2();
			modernDance.minus2();
			hiphop.minus2();
			fitnessstudio.minus2();
			judo.minus2();
			boxen.minus2();
			karate.minus2();
			volleyball.minus2();
			schwimmen.minus2();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		System.out.println(ballett.getSportarten() + " Punkte: " + ballett.getPunkte());
	}		
		
}
