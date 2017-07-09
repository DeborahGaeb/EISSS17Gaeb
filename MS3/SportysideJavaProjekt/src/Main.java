import java.util.Scanner;
	
public class Main {
		
	private static Testausfueren sporttest; 
	private static Scanner in;
	
	public static void main(String[] args){
		in = new Scanner(System.in);
		sporttest = new Testausfueren();
		sporttest.starteTest();
		sporttest.ergebnisBerechnen();
		
	
	}
}
