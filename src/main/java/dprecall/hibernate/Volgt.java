package dprecall.hibernate;

public class Volgt {
	private int studentID;
	private String vakCode;
	
	public Volgt(int studentID, String vakCode) {
		this.studentID = studentID;
		this.vakCode = vakCode;
	}
	
	public int getStudentID() {return studentID;}
	public String getVakCode() {return vakCode;}
	
	public void setStudentID(int studentID) {this.studentID = studentID;}
	public void setVakCode(String vakCode) {this.vakCode = vakCode;}
}
