 
public class QuizAntwort{
    // Entsanzvariablen der Klasse Quizantwort
    private String antworttext;
    private boolean antwortIstRichtig;
    private String kennzeichnung;
    

    /**
     * Constructor for objects of class QuizAntwort
     */
    public QuizAntwort(String antworttext, String kennzeichnung, boolean antwortIstRichtig)
    {
        // intizialisieren der Instanzvariablen. Erfolgt beim Erstellen eines Objekts. 
      
        this.antworttext = antworttext;
        this.antwortIstRichtig = antwortIstRichtig;
        this.kennzeichnung = kennzeichnung;
        
       
    }
    public String getAntworttext(){
    	return antworttext;
    }
    
    public String getKennzeichnung(){
    	return kennzeichnung;
    }
    
    public boolean getAntwortIstRichtig(){
    	return antwortIstRichtig;
    }
    
   //Ueberpruefen ob die gewaehlten Antworten eine richtige Kennzeichnung enth‰lt.
    public boolean checkAntwort (String gewaehlteAntworten){
        if(antwortIstRichtig == true && gewaehlteAntworten.contains (kennzeichnung.toUpperCase())){
            return true;  
        }
        else{
            return false;
        }
    }
}
