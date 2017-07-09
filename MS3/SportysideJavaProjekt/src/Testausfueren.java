import java.util.Scanner;

public class Testausfueren {
	//AlleSportarten ArrayListe
	private TupelSportarten[] alleSportarten; 
	
	//Tanzsport
	private TupelSportarten ballett;
	private TupelSportarten modernDance;
	private TupelSportarten hiphop;
		
	//Ballsportarten
	private TupelSportarten fussball;
	private TupelSportarten volleyball;
	private TupelSportarten tennis; 
		
	//Kampfsportarten
	private TupelSportarten judo;
	private TupelSportarten boxen;
	private TupelSportarten karate;
		
	//Fitness
	private TupelSportarten fitnessstudio;
	private TupelSportarten pilates;
	private TupelSportarten laufen;
		
	//reiten
	private TupelSportarten dressur;
	private TupelSportarten springen;
	private TupelSportarten vielseitigkeit;
	
	//Wassersport
	private TupelSportarten schwimmen;
	private TupelSportarten tauchen;
	private TupelSportarten kanuFahren;
	
	private Testantwort antwortA;
	private Testantwort antwortB;
	private Testantwort antwortC;
	private Testantwort antwortD;
	private Testantwort antwortE;
	private Testantwort antwortJa;
	private Testantwort antwortNein;
	
	private Scanner in; 
	
	public void starteTest() {
		in = new Scanner(System.in);
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
		antwortJa = new Testantwort("j", "ja");
		antwortNein = new Testantwort("n", "nein");
		
		Testfrage frage1 = new Testfrage(1, "Ich trainiere lieber in trockenen.");
		Testfrage frage2 = new Testfrage(2, "Ich trainiere lieber an der frischen Luft.");
		Testfrage frage3 = new Testfrage(3, "Bei schönem Wetter will ich Sport auch draußen machenv");
		Testfrage frage4 = new Testfrage(4, "Mein Motto alle für eine einer für alle.");
		Testfrage frage5 = new Testfrage(5, "Ich trainiere lieber für mich allein");
		Testfrage frage6 = new Testfrage(6, "Ich will leinen regel- mäßigen Termin haben.");
		Testfrage frage7 = new Testfrage(7, "Ich möchste Zeitlich unbegrenzt sein.");
		Testfrage frage8 = new Testfrage(8, "Magst du Tanzen?");
		Testfrage frage9 = new Testfrage(9, "Langsam und geschmeid- ige Bewegungen finde ich gut.");
		Testfrage frage10 = new Testfrage(10, "Schnell und modern macht mir an am meiste.");
		Testfrage frage11 = new Testfrage(11, "Moderne Musik mag ich mehr als HipHop.");
		Testfrage frage12 = new Testfrage(12, "Magst du Pferde?");
		Testfrage frage13 = new Testfrage(13, "Elegant, geschmeidig, in Harmonie mit dem Pferd reiten.");
		Testfrage frage14 = new Testfrage(14, "Schnelligkeit, über Hindernisse Springen macht mir Spaß.");
		Testfrage frage15 = new Testfrage(15, "Elgant aber doch Schnell und das Springen über Hindernisse.");
		Testfrage frage16 = new Testfrage(16, "Magst du Ballsportarten?");
		Testfrage frage17 = new Testfrage(17, "Schießen, Köpfen ist voll mein Ding.");
		Testfrage frage18 = new Testfrage(18, "Baggern, Pritischen, einen Ball werfen macht mir spaß.");
		Testfrage frage19 = new Testfrage(19, "Alleie oder zweit einen Ball mit Schläger zu spielen macht mir Spaß");
		Testfrage frage20 = new Testfrage(20, "Machst du gerne Kampfsport? ");
		Testfrage frage21 = new Testfrage(21, "Ich kämpfe mit meinen Fäusten.");
		Testfrage frage22 = new Testfrage(22, "Ich kämpfe gerne mit dem ganzen Körper aber ohne Waffen.");
		Testfrage frage23 = new Testfrage(23, "Ich kämpfe gerne mit dem ganzen Körper aber auch mit Waffen.");
		Testfrage frage24 = new Testfrage(24, "Ich bin eine Wasserratte.");
		Testfrage frage25 = new Testfrage(25, "Findest du de Unterwasserwelt faszinierent?");
		Testfrage frage26 = new Testfrage(26, "Bist du lieber auf dem Wasser als unter dem Wasser?");
		Testfrage frage27 = new Testfrage(27, "Schwimmst du gerne?");
		
		//1. Frage 
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
		
		else if (meineAntwort.equals(antwortC.getKennzeichnung())) {}
			
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
		
		//2. Frage Drinnen
		System.out.println(frage2.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
				
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {
			tennis.plus2();
			dressur.plus2();
			springen.plus2();
			vielseitigkeit.plus2();
			fussball.plus2();
			kanuFahren.plus2();
			tauchen.plus2();
			laufen.plus2();
		}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {
			tennis.plus1();
			dressur.plus1();
			springen.plus1();
			vielseitigkeit.plus1();
			fussball.plus1();
			kanuFahren.plus1();
			tauchen.plus1();
			laufen.plus1();
		}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {
			tennis.minus1();
			dressur.minus1();
			springen.minus1();
			vielseitigkeit.minus1();
			fussball.minus1();
			kanuFahren.minus1();
			tauchen.minus1();
			laufen.minus1();
		}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {
			tennis.minus2();
			dressur.minus2();
			springen.minus2();
			vielseitigkeit.minus2();
			fussball.minus2();
			kanuFahren.minus2();
			tauchen.minus2();
			laufen.minus2();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//3. Frage Drausen
		System.out.println(frage3.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {
			dressur.plus2();
			springen.plus2();
			vielseitigkeit.plus2();
			schwimmen.plus2();
			tauchen.plus2();
			tennis.plus2();
		}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {
			dressur.plus1();
			springen.plus1();
			vielseitigkeit.plus1();
			schwimmen.plus1();
			tauchen.plus1();
			tennis.plus1();
		}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {
			dressur.minus1();
			springen.minus1();
			vielseitigkeit.minus1();
			schwimmen.minus1();
			tauchen.minus1();
			tennis.minus1();
		}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {
			dressur.minus2();
			springen.minus2();
			vielseitigkeit.minus2();
			schwimmen.minus2();
			tauchen.minus2();
			tennis.minus2();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//4. Frage Gruppensport
		System.out.println(frage4.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {
			kanuFahren.plus2();
			volleyball.plus2();
			tennis.plus2();
			kanuFahren.plus2();
			tauchen.plus2(); 
		}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {
			kanuFahren.plus1();
			volleyball.plus1();
			tennis.plus1();
			kanuFahren.plus1();
			tauchen.plus1(); 
		}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {
			kanuFahren.minus1();
			volleyball.minus1();
			tennis.minus1();
			kanuFahren.minus1();
			tauchen.minus1(); 
		}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {
			kanuFahren.minus2();
			volleyball.minus2();
			tennis.minus2();
			kanuFahren.minus2();
			tauchen.minus2(); 
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//5. Frage Alleine 
		System.out.println(frage5.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {
			ballett.plus2();
			modernDance.plus2();
			hiphop.plus2();
			dressur.plus2();
			springen.plus2();
			vielseitigkeit.plus2();
			boxen.plus2();
			judo.plus2();
			karate.plus2();
			tennis.plus2();
		}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {
			ballett.plus1();
			modernDance.plus1();
			hiphop.plus1();
			dressur.plus1();
			springen.plus1();
			vielseitigkeit.plus1();
			boxen.plus1();
			judo.plus1();
			karate.plus1();
			tennis.plus1();
		}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {
			ballett.minus1();
			modernDance.minus1();
			hiphop.minus1();
			dressur.minus1();
			springen.minus1();
			vielseitigkeit.minus1();
			boxen.minus1();
			judo.minus1();
			karate.minus1();
			tennis.minus1();
		}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {
			ballett.minus2();
			modernDance.minus2();
			hiphop.minus2();
			dressur.minus2();
			springen.minus2();
			vielseitigkeit.minus2();
			boxen.minus2();
			judo.minus2();
			karate.minus2();
			tennis.minus2();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//6. Frage Regelmaessiges Training
		System.out.println(frage6.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {
			ballett.plus2();
			modernDance.plus2();
			hiphop.plus2();
			dressur.plus2();
			springen.plus2();
			vielseitigkeit.plus2();
			boxen.plus2();
			judo.plus2();
			karate.plus2();
			tennis.plus2();
			fussball.plus2();
			volleyball.plus2();
		}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {
			ballett.plus1();
			modernDance.plus1();
			hiphop.plus1();
			dressur.plus1();
			springen.plus1();
			vielseitigkeit.plus1();
			boxen.plus1();
			judo.plus1();
			karate.plus1();
			tennis.plus1();
			fussball.plus1();
			volleyball.plus1();
		}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {
			ballett.minus1();
			modernDance.minus1();
			hiphop.minus1();
			dressur.minus1();
			springen.minus1();
			vielseitigkeit.minus1();
			boxen.minus1();
			judo.minus1();
			karate.minus1();
			tennis.minus1();
			fussball.minus1();
			volleyball.minus1();
		}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {
			ballett.minus2();
			modernDance.minus2();
			hiphop.minus2();
			dressur.minus2();
			springen.minus2();
			vielseitigkeit.minus2();
			boxen.minus2();
			judo.minus2();
			karate.minus2();
			tennis.minus2();
			fussball.minus2();
			volleyball.minus2();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//7. Frage Zeitlich uneingeschraenkt 
		System.out.println(frage7.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {
			pilates.plus2();
			laufen.plus2();
			fitnessstudio.plus2();
			tauchen.plus2();
			schwimmen.plus2();
		}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {
			pilates.plus1();
			laufen.plus1();
			fitnessstudio.plus1();
			tauchen.plus1();
			schwimmen.plus1();
		}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {
			pilates.minus1();
			laufen.minus1();
			fitnessstudio.minus1();
			tauchen.minus1();
			schwimmen.minus1();
		}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {
			pilates.minus2();
			laufen.minus2();
			fitnessstudio.minus2();
			tauchen.minus2();
			schwimmen.minus2();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//8.Frage Ja Nein
		System.out.println(frage8.getFrage() + "Geben Sie j für Ja und n für Nein an.");
		System.out.println(antwortJa.getKennzeichnung() + " " + antwortJa.getAntwort());
		System.out.println(antwortNein.getKennzeichnung() + " " + antwortNein.getAntwort());
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortJa.getKennzeichnung())) {
			modernDance.plus10();
			ballett.plus10();
			hiphop.plus10();
		}
		else if(meineAntwort.equals(antwortNein.getKennzeichnung())) {
			modernDance.minus10();
			ballett.minus1();
			hiphop.minus10();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//9. Frage 
		System.out.println(frage9.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {ballett.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {ballett.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {ballett.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {ballett.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//10. Frage 
		System.out.println(frage11.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {modernDance.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {modernDance.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {modernDance.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {modernDance.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//11. Frage 
		System.out.println(frage10.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {hiphop.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {hiphop.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {hiphop.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {hiphop.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//12.Frage Ja Nein Reiten
		System.out.println(frage12.getFrage() + "Geben Sie j für Ja und n für Nein an.");
		System.out.println(antwortJa.getKennzeichnung() + " " + antwortJa.getAntwort());
		System.out.println(antwortNein.getKennzeichnung() + " " + antwortNein.getAntwort());
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortJa.getKennzeichnung())) {
			dressur.plus10();
			springen.plus10();
			vielseitigkeit.plus10();
		}
		else if(meineAntwort.equals(antwortNein.getKennzeichnung())) {
			dressur.minus10();
			springen.minus10();
			vielseitigkeit.minus10();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben j oder n ein");
			meineAntwort = in.next();
		}
		
		//13. Frage 
		System.out.println(frage13.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {dressur.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {dressur.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {dressur.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {dressur.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//14. Frage 
		System.out.println(frage14.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {springen.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {springen.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {springen.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {springen.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//15. Frage 
		System.out.println(frage15.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//16. Frage Ja oder nein 
		System.out.println(frage16.getFrage() + "Geben Sie j für Ja und n für Nein an.");
		System.out.println(antwortJa.getKennzeichnung() + " " + antwortJa.getAntwort());
		System.out.println(antwortNein.getKennzeichnung() + " " + antwortNein.getAntwort());
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortJa.getKennzeichnung())) {
			fussball.plus10();
			volleyball.plus10();
			tennis.plus10();
		}
		else if(meineAntwort.equals(antwortNein.getKennzeichnung())) {
			fussball.minus10();
			volleyball.minus10();
			tennis.minus10();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//17. Frage 
		System.out.println(frage17.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {fussball.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {fussball.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {fussball.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {fussball.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//18. Frage 
		System.out.println(frage18.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {volleyball.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {volleyball.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {volleyball.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {volleyball.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//19. Frage 
		System.out.println(frage19.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {tennis.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {tennis.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {tennis.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {tennis.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
				
		//20.Frage Ja Nein
		System.out.println(frage8.getFrage() + "Geben Sie j für Ja und n für Nein an.");
		System.out.println(antwortJa.getKennzeichnung() + " " + antwortJa.getAntwort());
		System.out.println(antwortNein.getKennzeichnung() + " " + antwortNein.getAntwort());
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortJa.getKennzeichnung())) {
			judo.plus10();
			boxen.plus10();
			karate.plus10();
		}
		else if(meineAntwort.equals(antwortNein.getKennzeichnung())) {
			judo.minus10();
			boxen.plus10();
			karate.plus10();
		}
		
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
				
		//21. Frage 
		System.out.println(frage21.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {boxen.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {boxen.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {boxen.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {boxen.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//22. Frage 
		System.out.println(frage22.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {judo.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {judo.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {judo.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {judo.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//23. Frage 
		System.out.println(frage23.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
						
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {karate.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {karate.plus2();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {karate.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {karate.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
				
		//24.Frage Ja Nein
		System.out.println(frage24.getFrage() + "Geben Sie j für Ja und n für Nein an.");
		System.out.println(antwortJa.getKennzeichnung() + " " + antwortJa.getAntwort());
		System.out.println(antwortNein.getKennzeichnung() + " " + antwortNein.getAntwort());
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortJa.getKennzeichnung())) {
			schwimmen.plus10();
			tauchen.plus10();
			kanuFahren.plus10();
		}
		else if(meineAntwort.equals(antwortNein.getKennzeichnung())) {
			schwimmen.minus10();
			tauchen.minus10();
			kanuFahren.minus10();
		}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
				
		//26. Frage 
		System.out.println(frage26.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
			
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {kanuFahren.plus2();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {kanuFahren.plus1();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {kanuFahren.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {kanuFahren.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		
		//25. Frage 
		System.out.println(frage25.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
			
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {tauchen.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {tauchen.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {tauchen.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {tauchen.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
		//27. Frage 
		System.out.println(frage27.getFrage());
		System.out.println(antwortA.getKennzeichnung() + " " + antwortA.getAntwort());
		System.out.println(antwortB.getKennzeichnung() + " " + antwortB.getAntwort());
		System.out.println(antwortC.getKennzeichnung() + " " + antwortC.getAntwort());
		System.out.println(antwortD.getKennzeichnung() + " " + antwortD.getAntwort());
		System.out.println(antwortE.getKennzeichnung() + " " + antwortE.getAntwort());
			
		meineAntwort = in.next();
		if(meineAntwort.equals(antwortA.getKennzeichnung())) {schwimmen.plus2();}
		else if(meineAntwort.equals(antwortB.getKennzeichnung())) {schwimmen.plus1();}
		else if(meineAntwort.equals(antwortC.getKennzeichnung())) {}
		else if(meineAntwort.equals(antwortD.getKennzeichnung())) {schwimmen.minus1();}
		else if(meineAntwort.equals(antwortE.getKennzeichnung())) {schwimmen.minus2();}
		else {
			System.out.println("Bitte Geben Sie nur Buchstaben A, B, C, D, E ein");
			meineAntwort = in.next();
		}
	}
	public void addSportart(TupelSportarten[] alleSportarten) {
		alleSportarten = new TupelSportarten[18];
		
		alleSportarten[0] = ballett;
		alleSportarten[1] = modernDance;
		alleSportarten[2] = hiphop;
		alleSportarten[3] = fussball;
		alleSportarten[4] = volleyball;
		alleSportarten[5] = tennis;
		alleSportarten[6] = judo;
		alleSportarten[7] = boxen;
		alleSportarten[8] = karate;
		alleSportarten[9] = fitnessstudio;
		alleSportarten[10] = laufen;
		alleSportarten[11] = pilates;
		alleSportarten[12] = dressur;
		alleSportarten[13] = springen;
		alleSportarten[14] = vielseitigkeit;
		alleSportarten[15] = schwimmen;
		alleSportarten[16] = tauchen;
		alleSportarten[17] = kanuFahren;
		
	}
	public void ergebnisBerechnen() {
		TupelSportarten gross = new TupelSportarten("", 0);
		for (int i = 0; i < alleSportarten.length; i++) {
			if (alleSportarten[i].getPunkte() > gross.getPunkte()) {
				gross = alleSportarten[i];
			}
		}
		System.out.println("Die ideale Spportart für Sie ist: " + gross.getSportarten() + " mit: " + gross.getPunkte() + "Punkten.");
	}
}
