package dprecall.entitys;

public class Vak {
	private String code;
	private String naam;
	private int ects;
	
	public Vak(String code, String naam, int ects) {
		this.code = code;
		this.naam = naam;
		this.ects = ects;
	}
	
	public String getCode() {return code;}
	public String getNaam() {return naam;}
	public int getECTS() {return ects;}
	
	public void setCode(String code) {this.code = code;}
	public void setNaam(String naam) {this.naam = naam;}
	public void setECTS(int ects) {this.ects = ects;}

	@Override
	public String toString () {
		return "Code: " +this.getCode()+ " Naam: " +this.getNaam()+ " Aantal ECTS: " + this.getECTS();
	}
}
