package dprecall.hibernate;

public class Klas {
	private String klascode;
	private String mentor;
	private int startjaar;
	
	public Klas(String klascode, String mentor, int startjaar) {
		this.klascode = klascode;
		this.mentor = mentor;
		this.startjaar = startjaar;
	}
	
	public String getKlasCode() {return klascode;}
	public String getMentor() {return mentor;}
	public int getStartjaar() {return startjaar;}
}
