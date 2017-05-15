import java.util.Scanner;

public class QuizFrage {
	// instance variables
    private String quizFrageText;
    private QuizAntwort[] antworten;
    
    
    /**
     * Constructor for objects of class QuizFrage
     */
    
    public QuizFrage(String quizFrage, QuizAntwort ... antworten){
		      
    	//Instanzvaiablen der Klasse QuizFrage
		        this.quizFrageText = quizFrage;
		        this.antworten = new QuizAntwort[5]; 
		        this.antworten = antworten;
		    }
		
		    public int frageStellen(){
		        System.out.println(quizFrageText);
		        
		        for(int i = 0; i < antworten.length; i++){
		        	System.out.println(antworten[i].getKennzeichnung() + ": " + antworten[i].getAntworttext());
		        }
		        //Eingabe der Antwort 
		        Scanner in = new Scanner(System.in);
		        System.out.println("Bitte geben Sie Ihre Antwort ein: ");
		        String kennzeichnung = in.next().toUpperCase(); 
		        
		        int anzahlRichtigeAnworten = 0;
		        int anzahlRichtigeGegebeneAntworten = 0;
		        
		        //Ueberpruefen ob die Antwort richtig ist
		        for(int i = 0; i < antworten.length; i++){
		        	if(antworten[i].getAntwortIstRichtig()){
		        		anzahlRichtigeAnworten++;
		        	}
		            if(antworten[i].checkAntwort(kennzeichnung)){
		            	anzahlRichtigeGegebeneAntworten++;
		            }
        }
        System.out.println("Es sind " + anzahlRichtigeGegebeneAntworten + " von " + anzahlRichtigeAnworten+ " richtig");
        return anzahlRichtigeGegebeneAntworten;
    }
		    
     public String gibQuizFrageText(){
    	 return quizFrageText;
     }
     
     public QuizAntwort[] gibQuizAntworten(){
    	 return antworten;
     }
    
}
