package dprecall.hibernate;

import java.util.Date;

public class Student {
	private int id;
	private String naam;
	private Date gbdatum;
	private String klas_code;
	
	public Student(int id, String naam, Date gbdatum, String klascode) {
		this.id = id;
		this.naam = naam;
		this.gbdatum = gbdatum;
		this.klas_code = klascode;
	}
	public Student() {

	}
	public int getID() {return id;}
	public String getNaam() {return naam;}
	public Date getGBdatum() {return gbdatum;}
	public String getKlasCode() {return klas_code;}
	
	public void setID(int id) {this.id = id;}
	public void setNaam(String naam) {this.naam = naam;}
	public void setGBdatum(Date gbdatum) {this.gbdatum = gbdatum;}
	public void setKlasCode(String klascode) {this.klas_code = klascode;}
}
