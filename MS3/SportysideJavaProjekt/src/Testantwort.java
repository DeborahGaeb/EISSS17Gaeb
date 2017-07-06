
public class Testantwort {
	private String kennzeichnung;
	private String antwort;
	
	public Testantwort (String kennzeichnung, String antwort) {
		this.kennzeichnung = kennzeichnung;
		this.antwort = antwort;
	}

	public String getAntwort() {
		return antwort;
	}

	public void setAntwort(String antwort) {
		this.antwort = antwort;
	}

	public String getKennzeichnung() {
		return kennzeichnung;
	}

	public void setKennzeichnung(String kennzeichnung) {
		this.kennzeichnung = kennzeichnung;
	}
}
