package dprecall.hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Vak")
public class Vak {
	@Id
	@Column(name="CODE")
	private String code;
	@Column(name="NAAM")
	private String naam;
	@Column(name="ECTS")
	private int ects;
	@ManyToMany(mappedBy = "vakken")
	private Set<Student> studenten = new HashSet<>();

	public Vak () {
	}

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
