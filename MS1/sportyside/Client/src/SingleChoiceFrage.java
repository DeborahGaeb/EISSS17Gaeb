
public class SingleChoiceFrage extends QuizFrage{
	
	int punkte;
	
	//Einleitung der Vererbung
	public SingleChoiceFrage(String quizFrage,int  punkte,QuizAntwort ... antworten) throws Exception{
		super(quizFrage, antworten);
		this.punkte = punkte;
		
		boolean eineAntwortIstRichtig = false;
		for(QuizAntwort antwort : antworten){
			if(antwort.getAntwortIstRichtig()){
				if(eineAntwortIstRichtig == true){
					throw new Exception("SingleChoiceFrage draf nur eine richtige Antwort enthalten!");
				}
				eineAntwortIstRichtig = true;
			}
		}
	}
	

}
