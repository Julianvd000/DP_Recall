package dprecall.entitys;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	private int id;
	private String naam;
	private Date gbdatum;
	private Klas klas;
	private ArrayList<Vak> vakken = new ArrayList<Vak>();

	public Student(int id, String naam, Date gbdatum,  Klas klas) {
		this.id = id;
		this.naam = naam;
		this.gbdatum = gbdatum;
		this.klas = klas;
	}

	public int getId () {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}

	public String getNaam () {
		return naam;
	}

	public void setNaam (String naam) {
		this.naam = naam;
	}

	public Date getGbdatum () {
		return gbdatum;
	}

	public void setGbdatum (Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	public Klas getKlas () {
		return klas;
	}

	public void setKlas (Klas klas) {
		this.klas = klas;
	}

	public ArrayList<Vak> getVakken () {
		return vakken;
	}

	public void setVakken (ArrayList<Vak> vakken) {
		this.vakken = vakken;
	}
	public void voegVakToe(Vak vak){
		if (!this.vakken.contains(vak)) {
			this.vakken.add(vak);
		}
	}
	public void verwijderVak(Vak vak){
		if (this.vakken.contains(vak)) {
			this.vakken.remove(vak);
		}
	}

	@Override
	public String toString () {
		String Student = "id: " + this.getId() + " naam: " + this.getNaam() + " geboortedatum: " +  this.getGbdatum();
		if (!vakken.isEmpty()){
			for (Vak vak : vakken) {
				Student += " Heeft de volgende vakken: \n";
				Student += vak.toString();
				Student += "\n";
			}
		}
		return Student;
	}
}
