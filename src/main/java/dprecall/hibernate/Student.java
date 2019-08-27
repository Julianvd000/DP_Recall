package dprecall.hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name="ID")
	private int id;
	@Column(name="NAAM")
	private String naam;
	@Column(name="GBDATUM")
	private Date gbdatum;
	@ManyToOne
	@JoinColumn(name="KLAS_CODE", nullable=false)
	private Klas klas;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "VOLGT",
			joinColumns = { @JoinColumn(name = "STUDENT_ID") },
			inverseJoinColumns = { @JoinColumn(name = "VAK_CODE") }
	)
	private Set<Vak> vakken = new HashSet<Vak>();

	public Student(int id, String naam, Date gbdatum,  Klas klas) {
		this.id = id;
		this.naam = naam;
		this.gbdatum = gbdatum;
		this.klas = klas;
	}
	public Student (){}
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

	public Set<Vak> getVakken () {
		return vakken;
	}

	public void setVakken (Set<Vak> vakken) {
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
		String Student = "id: " + this.getId() + " naam: " + this.getNaam() + " geboortedatum: " +  this.getGbdatum() +  " zit in klas: " + this.getKlas().getKlascode();
		if (!vakken.isEmpty()){
			Student += "\nHeeft de volgende vakken: \n";
			for (Vak vak : vakken) {
				Student += vak.toString();
				Student += "\n";
			}
		}
		return Student;
	}
}
