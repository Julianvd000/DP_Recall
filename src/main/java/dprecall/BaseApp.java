package dprecall;

import dprecall.DOAimpl.klasDAOimpl;
import dprecall.DOAimpl.studentDAOimpl;
import dprecall.DOAimpl.vakDAOimpl;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;
import dprecall.entitys.Vak;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseApp {
    private static studentDAOimpl studentdao = new studentDAOimpl();
    private static klasDAOimpl klasdao = new klasDAOimpl();
    private static vakDAOimpl vakdao = new vakDAOimpl();

    public static void main(String[] arg) throws SQLException {
        //Save~Create
        Vak vak1 = new Vak("RAD", "Rapid Application Development", 5);
        Klas klas1 = new Klas("V2A", "James", 2019);
        Student student1 = new Student(3,"Rick", null , klas1);

        vakdao.save(vak1);
        klasdao.save(klas1);
        studentdao.save(student1);
        studentdao.StudentVolgtVak(student1,vak1);
        System.out.println("Alle tabbelen \n");
        //Read alle tabbelen

        for (Vak vak : vakdao.findAll()){
            System.out.println(vak.toString());
        }
        for (Student student: studentdao.findAll()) {
            System.out.println(student.toString());
        }
        for (Klas klas: klasdao.findAll()) {
            System.out.println(klas.toString());
        }

        //Update alle objecten
        System.out.println("update sommige objecten \n");
        vak1.setNaam("Rapid Applications DevelopmentScience");
        vakdao.update(vak1);
        klas1.setStartjaar(2018);
        klasdao.update(klas1);
        student1.setNaam("James Maxim");
        studentdao.update(student1);

        System.out.println(vakdao.findByCode(vak1.getCode()));
        System.out.println(klasdao.findByCode(klas1.getKlascode()));
        System.out.println(studentdao.findByID(student1.getId()));

        System.out.println("Print alles samen gevoegd objecten \n");

        //Combineer de data (Read)
        ArrayList<Klas> klassen = klasdao.findAll();
        ArrayList<Student>studenten = studentdao.findAll();
        for (Student student: studenten) {
           student.setVakken(studentdao.krijgAlleVakken(student));
        }
        ArrayList<Klas> KlasMetStudenten;
        for (Student student: studenten){
            for (Klas klas : klassen){
                if (klas.getKlascode().equals(student.getKlas().getKlascode())){
                    klas.voegStudentToe(student);
                }
            }
        }
        for (Klas klas: klassen) {
            System.out.println(klas);
        }

        //delete alle op objecten
        studentdao.delete(student1);
        klasdao.delete(klas1);
        vakdao.delete(vak1);

        System.out.println("\n read na de delete \n");
        for (Vak vak : vakdao.findAll()){
            System.out.println(vak.toString());
        }
        for (Student student: studentdao.findAll()) {
            System.out.println(student.toString());
        }
        for (Klas klas: klasdao.findAll()) {
            System.out.println(klas.toString());
        }
    }

    public void readAlles(){

    }
}