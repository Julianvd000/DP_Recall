package dprecall.hibernate;

public class Volgt {
	private int student_id;
	private String vak_code;
	
	public Volgt(int studentID, String vakCode) {
		this.student_id = studentID;
		this.vak_code = vakCode;
	}

	public Volgt () {
	}

	public int getStudentID() {return student_id;}
	public String getVakCode() {return vak_code;}
	
	public void setStudentID(int studentID) {this.student_id = studentID;}
	public void setVakCode(String vakCode) {this.vak_code = vakCode;}
}
