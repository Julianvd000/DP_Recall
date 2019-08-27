package dprecall.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "KLAS")
public class Klas {

    @Id
    @Column(name="CODE")
    private String klascode;
    @Column(name="MENTOR")
    private String mentor;
    @Column(name="STARTJAAR")
    private int startjaar;
    @OneToMany(mappedBy="klas")
    private Set<Student> student = new HashSet<Student>();

    public Klas(String klascode, String mentor, int startjaar) {
        this.klascode = klascode;
        this.mentor = mentor;
        this.startjaar = startjaar;
    }

    public Klas () {
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

    public Set<Student> getStudenten () {
        return student;
    }

    public void setStudenten (Set<Student> studenten) {
        this.student = studenten;
    }
    public void voegStudentToe(Student student){
        if (!this.student.contains(student)) {
            this.student.add(student);
        }
    }
    public void verwijderStudent(Student student){
        if (this.student.contains(student)) {
            this.student.remove(student);
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
