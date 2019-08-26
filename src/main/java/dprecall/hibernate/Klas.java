package dprecall.hibernate;

public class Klas {
	private String code;
	private String mentor;
	private int startjaar;
	
	public Klas(String klascode, String mentor, int startjaar) {
		this.code = klascode;
		this.mentor = mentor;
		this.startjaar = startjaar;
	}

	public Klas () {
	}

	public void setCode (String code) {
		this.code = code;
	}

	public void setMentor (String mentor) {
		this.mentor = mentor;
	}

	public void setStartjaar (int startjaar) {
		this.startjaar = startjaar;
	}

	public String getKlasCode() {return code;}
	public String getMentor() {return mentor;}
	public int getStartjaar() {return startjaar;}
}
