package dprecall.hibernate;

public class Vak {
	private String code;
	private String naam;
	private int ects;
	
	public Vak(String code, String naam, int ects) {
		this.code = code;
		this.naam = naam;
		this.ects = ects;
	}

	public Vak () {
	}

	public String getCode() {return code;}
	public String getNaam() {return naam;}
	public int getECTS() {return ects;}
	
	public void setCode(String code) {this.code = code;}
	public void setNaam(String naam) {this.naam = naam;}
	public void setECTS(int ects) {this.ects = ects;}
}
