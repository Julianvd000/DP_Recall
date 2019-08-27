package dprecall.entitys;

import java.util.ArrayList;

public class Klas {
	private String klascode;
	private String mentor;
	private int startjaar;
	private ArrayList<Student> studenten = new ArrayList<Student>();

	public Klas(String klascode, String mentor, int startjaar) {
		this.klascode = klascode;
		this.mentor = mentor;
		this.startjaar = startjaar;
	}

	public String getKlascode () {
		return klascode;
	}

	public void setKlascode (String klascode) {
		this.klascode = klascode;
	}

	public String getMentor () {
		return mentor;
	}

	public void setMentor (String mentor) {
		this.mentor = mentor;
	}

	public int getStartjaar () {
		return startjaar;
	}

	public void setStartjaar (int startjaar) {
		this.startjaar = startjaar;
	}

	public ArrayList<Student> getStudenten () {
		return studenten;
	}

	public void setStudenten (ArrayList<Student> studenten) {
		this.studenten = studenten;
	}
	public void voegStudentToe(Student student){
		if (!this.studenten.contains(student)) {
			this.studenten.add(student);
		}
	}
	public void verwijderStudent(Student student){
		if (this.studenten.contains(student)) {
			this.studenten.remove(student);
		}
	}

	@Override
	public String toString () {
		String Klas = "Klas: " + this.getKlascode() + " met de Mentor: " +this.getMentor()+ " Startjaar: " + this.getStartjaar();
		if(!this.getStudenten().isEmpty()){
			Klas += "\nHeeft de volgend studenten: \n";
			for (Student Student: this.getStudenten()) {
				Klas += "~~ \n";
				Klas += Student.toString();
				Klas += "\n~~ \n";
			}
		}
		return Klas;
	}
}
