package dprecall.entitys;

import java.util.Date;

public class Student {
	private int id;
	private String naam;
	private Date gbdatum;
	private String klascode;
	
	public Student(int id, String naam, Date gbdatum, String klascode) {
		this.id = id;
		this.naam = naam;
		this.gbdatum = gbdatum;
		this.klascode = klascode;
	}
	
	public int getID() {return id;}
	public String getNaam() {return naam;}
	public Date getGBdatum() {return gbdatum;}
	public String getKlasCode() {return klascode;}
	
	public void setID(int id) {this.id = id;}
	public void setNaam(String naam) {this.naam = naam;}
	public void setGBdatum(Date gbdatum) {this.gbdatum = gbdatum;}
	public void setKlasCode(String klascode) {this.klascode = klascode;}
}
