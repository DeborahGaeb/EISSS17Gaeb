
public class TupelSportarten {
	private int punkte;
	private String sportarten;
	
	//Konstruktor
	public TupelSportarten(String sportarten, int punkte) {
		this.sportarten = sportarten;
		this.punkte = punkte;
	}
	
	//Punkte berechnen
	public void plus2() {
		punkte = punkte + 2;
	}
	public void plus1() {
		punkte = punkte + 1;
	}
	public void minus1() {
		punkte = punkte - 1;
	}
	public void minus2() {
		punkte = punkte - 2;
	}
	
	//Setter und Getter Methode 
	public int getPunkte() {
		return punkte;
	}
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	public String getSportarten() {
		return sportarten;
	}
	public void setSportarten(String sportarten) {
		this.sportarten = sportarten;
	} 
}
