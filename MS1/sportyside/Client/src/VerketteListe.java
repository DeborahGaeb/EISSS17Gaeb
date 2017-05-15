import java.util.Random;

public class VerketteListe{
	
	/*Eine Verkette Liste besteht aus Konten: listenAnfang (Node) -> Node -> Node -> Node -> letzterKnoten (Node)*/
	private Node listenAnfang; //Einstieg in die Liste
	private int anzahlFragen;
	private boolean isSorted = true;
	
	/**
	* Fügt eine QuizFrage am Ende der Liste ein
	* @param frage wird als letztes Element der Liste eingefügt */
	public void addLastQuestion (QuizFrage frage){
		if(!isEmpty()){
			Node nachsterNode = listenAnfang.gibNaechsterNode();
			Node vorgaenger = listenAnfang; //Vorgaenger muss gemerkt werden, da wir am Ende 1x mal "zuweit" gegangen sind beim prüfen, ob noch ein weiteres Element vorhanden ist.
			while(nachsterNode != null){ //gehe bis zum letzen Knoten
				vorgaenger = nachsterNode;
				nachsterNode = nachsterNode.gibNaechsterNode(); //Gehe einen Knoten weiter
			}
			vorgaenger.setNaechsterNode(new Node(frage, null)); //Erstelle neuen Knoten und speichere darin Frage
		}
		else{
			/*Liste ist leer, füge 1. Knoten direket am Anfang ein*/
			listenAnfang = new Node(frage, null);
		}
		anzahlFragen++;
		isSorted = false;
	}
	
	/**
	* Fügt eine QuizFrage sortiert ein. Sortiert wird nach dem Fragetext,
	* z.B. steht „Wie viele Einwohner hat Köln“ alphabetisch hinter
	* „An welchem Tag beginnt das neue Jahr?“.
	* @param frage wird alphabetisch (nach Fragetext der QuizFrage) einsortiert */
	public void addSorted (QuizFrage frage){
			boolean richtigePositionGefunden = false;
			Node vorgaenger = null;
			Node zuVergleichendeNode = listenAnfang; 
			
			while(!richtigePositionGefunden){
				if(zuVergleichendeNode != null){
					
					//Vergleiche die beiden Fragen
					String zuVergleichendeFrage = zuVergleichendeNode.gibFrage().gibQuizFrageText();
					int compareErgebis = frage.gibQuizFrageText().compareTo(zuVergleichendeFrage);
					
					if(compareErgebis == 0){ //beide Fragen sind gleich
						/* Da beide Fragen gleich sind -> Reihenfolge egal -> fuege neuen Node in Kette ein
						 * der zuVergleichendeFrage.nachsterNode wird zu nachsterNode des neuen Nodes, sodass die Kette weitergeht */
						zuVergleichendeNode.naechsterNode = new Node(frage, zuVergleichendeNode.naechsterNode); 
						richtigePositionGefunden = true;
					}
					else if(compareErgebis > 0){ //frage ist alphabetisch größer als zuVergleichendeFrage --> gehe eine Ebene tiefer in der Kette, da richtige Position in der Kette noch nicht erreicht wurde
						vorgaenger = zuVergleichendeNode;
						zuVergleichendeNode = zuVergleichendeNode.naechsterNode;
					}
					else{  //frage ist alphabetisch kleiner als zuVergleichendeFrage
						if(vorgaenger == null){ //Fuege eine neue 1. Node ein 
							vorgaenger = new Node(frage, zuVergleichendeNode);
							listenAnfang = vorgaenger;
							richtigePositionGefunden = true;
						}
						else{
							vorgaenger.naechsterNode = new Node(frage, zuVergleichendeNode); //Fuege Node an richtiger Stelle ein. zuVergleichendeNode rutscht eine Ebene tiefer in der Kette
							richtigePositionGefunden = true;	
						}
					}
				}	
				else{ //Ende der Liste oder leere Liste
					if(isEmpty()){ //leere Liste
						listenAnfang = new Node(frage, null); //Setze Node direkt an den Anfang
					}
					else{
						vorgaenger.naechsterNode = new Node(frage, null); //Fuege Node an Ende hinzu --> Node hat keinen Nachfolger
					}
					richtigePositionGefunden = true;
				}
			}
		anzahlFragen++;
	}
	
	/** *
	* Sortiert die vorhandenen Elemente der Liste
	*/
	public void sort(){
		VerketteListe neueSortierteListe = new VerketteListe();
		Node node = listenAnfang;
		while(node != null){
			neueSortierteListe.addSorted(node.gibFrage());
			node = node.naechsterNode;
		}
		this.listenAnfang = neueSortierteListe.listenAnfang;
		isSorted = true;
	}
	
	/** *
	* @return wahr, wenn alle Elemente der der Liste sortiert sind
	*/
	public boolean isSorted(){
		if(isEmpty() || questionCount() == 1){
			return true;
		}
		else{
			return isSorted;
		}
	}
	
	/** *
	* @return wahr, wenn die Liste leer ist.
	*/
    public boolean isEmpty (){
        /*Eine Liste ist leer, wenn sie keine Fragen enthält.*/
        if(anzahlFragen == 0){
            return true;
        }
        else{
            return false;
        }
		
		/*Auch folgendes moeglich:
		Eine Liste ist leer, wenn sie keinen Anfang besitzt.
		if(listenAnfang ==  null){
			return true;
		}
		else{
			return false;
		}*/
	}
	
	/** *
	* @return Anzahl der Quiz-Fragen, die in der Liste vorhandenen sind
	*/
	public int questionCount (){
		return anzahlFragen;
	}
	
	/** *
	* @return liefert eine zufällige Quiz-Frage der Liste*/
	public QuizFrage randomQuestion (){
		/*Generiere Zufallszahl*/ 
		Random zufall = new Random();
		 int positionFrage = zufall.nextInt(anzahlFragen) + 1;
		 
		 if(!isEmpty()){
			 Node nachster = listenAnfang;
			 int i = 0;
			 /*Gehe bis zur Position die durch die Zufallszahl ausgewaehlte wurde durch die Liste.*/
			 while(i < positionFrage-1){
				 nachster = nachster.gibNaechsterNode();
				 i++;
			 }
			 /*Gib zufällige Frage zurück.*/
			 return nachster.gibFrage();
		 }
		 else{
			 /*Liste ist leer. Es kann keine Frage zurückgegeben werden.*/
			 return null;
		 }
	}
	
	/*Eine Verkette Liste besteht aus Knoten. 
	 * Ein Konten besteht kennt den naechsten Knoten in der Liste. 
	 * Zudem wird in jedem Koten eine Frage bespeichert.*/
	public class Node{
		private QuizFrage frage;
		private Node naechsterNode;
		
		//Erstelle neuen Knoten zum Abspeichern in der Liste.
		public Node(QuizFrage frage, Node naechsterNode){
			this.frage = frage;
			this.naechsterNode = naechsterNode;
		}
		
		//Gib das gespeicherte QuizFrage-Objekt zurück.
		public QuizFrage gibFrage(){
			return frage;
		}
		
		//Gib den naechsten Knoten in der Liste zurück.
		public Node gibNaechsterNode(){
			return naechsterNode;
		}
		
		//Merke den naechsten Knoten in der Liste
		public void setNaechsterNode(Node naechsterNode){
			this.naechsterNode = naechsterNode;
		}
	}
	
	public void testVerketteListe(){
		try {
			testIsEmpty();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			testSort();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			testQuestionCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			testIsSorted();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			testAddLastQuestion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*Test-Methoden*/
	public void testIsEmpty() throws Exception{
		VerketteListe liste = new VerketteListe();
		boolean listeIstLeer = liste.isEmpty();
		
		if(!listeIstLeer){
			//Liste muss am Anfang leer sein
			throw new Exception("Fehler: isEmpty()");
		}
		
		//Fuege eine neue Frage hinzu
		QuizFrage qf = new QuizFrage ("Welche Lebensmittel sind gesund?",
				new QuizAntwort ("Apfel", "A", true),
				new QuizAntwort ("Chips", "B", false),
				new QuizAntwort ("Orange", "C", true),
				new QuizAntwort ("Schokolade", "D", false),
				new QuizAntwort("Moeren","E", true));
		liste.addLastQuestion(qf);
		
		listeIstLeer = liste.isEmpty();
		if(listeIstLeer){
			//Liste darf nicht leer sein, sobald eine Frage hinzugefuegt wurde
			throw new Exception("Fehler: isEmpty()");
		}
	}
	
	public void testSort() throws Exception{
		VerketteListe liste = new VerketteListe();
		
		QuizFrage qf1 = new QuizFrage ("Welches ist kein klassisches Geraet bei Leistungsturnen der Maenner?",
				new QuizAntwort ("Schwebebalken", "A", true),
				new QuizAntwort ("Boden", "B", false),
				new QuizAntwort ("Sprung", "C", false),
				new QuizAntwort ("Pauschenpferd", "D", false),
				new QuizAntwort("Stufenbarren","E", true));
		liste.addLastQuestion(qf1);
		
		QuizFrage qf = new QuizFrage ("Welche Lebensmittel sind gesund?",
				new QuizAntwort ("Apfel", "A", true),
				new QuizAntwort ("Chips", "B", false),
				new QuizAntwort ("Orange", "C", true),
				new QuizAntwort ("Schokolade", "D", false),
				new QuizAntwort("Moeren","E", true));
		liste.addLastQuestion(qf);
		
		
		liste.sort();
		
		if(!(liste.listenAnfang.gibFrage().equals(qf))){
			//Eine Frage die mit Welche beginnt muss vor einer Frage stehen die mit Welches beginnt
			throw new Exception("Fehler: sort()");
		}
	}
	
	public void testQuestionCount() throws Exception{
		VerketteListe liste = new VerketteListe();
		int questionCount = liste.questionCount();
		
		if(!(questionCount == 0)){
			//Liste muss am Anfang leer sein
			throw new Exception("Fehler: questionCount()");
		}
		
		//Fuege eine neue Frage hinzu
		QuizFrage qf = new QuizFrage ("Welche Lebensmittel sind gesund?",
				new QuizAntwort ("Apfel", "A", true),
				new QuizAntwort ("Chips", "B", false),
				new QuizAntwort ("Orange", "C", true),
				new QuizAntwort ("Schokolade", "D", false),
				new QuizAntwort("Moeren","E", true));
		liste.addLastQuestion(qf);
		
		questionCount = liste.questionCount();
		if(questionCount == 0){
			//Liste darf nicht leer sein, sobald eine Frage hinzugefuegt wurde
			throw new Exception("Fehler: questionCount()");
		}
	}
	
	public void testIsSorted() throws Exception{
		VerketteListe liste = new VerketteListe();
		boolean istSortiert = liste.isSorted();
		if(!istSortiert){
			//Eine leere Liste ist automatisch sortiert
			throw new Exception("Fehler: isSorted()");
		}
		
		QuizFrage qf = new QuizFrage ("Welche Lebensmittel sind gesund?",
				new QuizAntwort ("Apfel", "A", true),
				new QuizAntwort ("Chips", "B", false),
				new QuizAntwort ("Orange", "C", true),
				new QuizAntwort ("Schokolade", "D", false),
				new QuizAntwort("Moeren","E", true));
		liste.addSorted(qf);
		
		istSortiert = liste.isSorted();
		if(!istSortiert){
			//Eine Liste mit nur einem Element ist automatisch sortiert
			throw new Exception("Fehler: isSorted()");
		}
		
		QuizFrage qf1 = new QuizFrage ("Welches ist kein klassisches Geraet bei Leistungsturnen der Maenner?",
				new QuizAntwort ("Schwebebalken", "A", true),
				new QuizAntwort ("Boden", "B", false),
				new QuizAntwort ("Sprung", "C", false),
				new QuizAntwort ("Pauschenpferd", "D", false),
				new QuizAntwort("Stufenbarren","E", true));
		liste.addSorted(qf);
		
		istSortiert = liste.isSorted();
		if(!istSortiert){
			//Eine Liste in der nur sortiert eingefügt wurde(addSorted(frage)) ist sortiert.
			throw new Exception("Fehler: isSorted()");
		}
		
		QuizFrage qf2 = null;
		try { //try-catch wird verwendet, da SingleChoiceFrage eine Exception wirft, wenn mehr las eine Antwort richtig ist
					qf2 = new SingleChoiceFrage ("Was ist die Hauptstadt von Deutschland?", 1,
					new QuizAntwort ("Berlin", "A", true),
					new QuizAntwort ("Bonn", "B", false),
					new QuizAntwort ("Muenchen", "C", false),
					new QuizAntwort ("Koeln", "D", false));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		liste.addLastQuestion(qf2);
		istSortiert = liste.isSorted();
		if(istSortiert){
			//Bei einer Liste, in die eine Frage unsortiert eingefuegt wurde, kann nicht mehr garantiert werden, dass sie sortiert ist
			throw new Exception("Fehler: isSorted()");
		}
	}
	
	public void testAddLastQuestion() throws Exception{
		VerketteListe liste = new VerketteListe();
		//Fuege eine neue Frage hinzu
		QuizFrage qf = new QuizFrage ("Welche Lebensmittel sind gesund?",
				new QuizAntwort ("Apfel", "A", true),
				new QuizAntwort ("Chips", "B", false),
				new QuizAntwort ("Orange", "C", true),
				new QuizAntwort ("Schokolade", "D", false),
				new QuizAntwort("Moeren","E", true));
		
		QuizFrage qf1 = new QuizFrage ("Welches ist kein klassisches Geraet bei Leistungsturnen der Maenner?",
				new QuizAntwort ("Schwebebalken", "A", true),
				new QuizAntwort ("Boden", "B", false),
				new QuizAntwort ("Sprung", "C", false),
				new QuizAntwort ("Pauschenpferd", "D", false),
				new QuizAntwort("Stufenbarren","E", true));
		
		liste.addLastQuestion(qf);
		liste.addLastQuestion(qf1);
		
		if(!liste.listenAnfang.naechsterNode.gibFrage().equals(qf1)){
			//Wenn zwei Fragen hinzugefuegt wurden, muss die zweite Frage das Nachfolger-Element in der Verketten Liste der 1.Frage sein
			throw new Exception("Fehler: addLastQuestion()");
		}
	}
	
	public void testRandomQuestion() throws Exception{
		throw new Exception("Fehler: randomQuestion() kann nicht getestet werden, da sie mehrmals nacheinander die selbe Frage liefern kann!");
	}
}