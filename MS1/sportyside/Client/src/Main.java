import java.util.ArrayList;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		
		QuizFrage qf = new QuizFrage ("Blabla",
				new QuizAntwort ("bla", "A", true),
				new QuizAntwort ("bla", "B", false),
				new QuizAntwort ("bla", "C", true),
				new QuizAntwort ("asdg", "D", false),
				new QuizAntwort("asddf","E", true));
		
		
		QuizFrage qf1 = new QuizFrage ("adsfkjldsa?",
				new QuizAntwort ("", "A", true),
				new QuizAntwort ("", "B", false),
				new QuizAntwort ("", "C", false),
				new QuizAntwort ("", "D", false),
				new QuizAntwort("","E", true));
		
		
		try { //try-catch wird verwendet, da SingleChoiceFrage eine Exception wirft, wenn mehr las eine Antwort richtig ist
			QuizFrage qf2 = new SingleChoiceFrage ("dasfhgh", 1,
					new QuizAntwort ("", "A", true),
					new QuizAntwort ("", "B", false),
					new QuizAntwort ("Muenchen", "C", false),
					new QuizAntwort ("Koeln", "D", false));
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			

	}

}
