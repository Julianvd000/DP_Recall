package dprecall;

import dprecall.DOAimpl.klasDAOimpl;
import dprecall.DOAimpl.studentDAOimpl;
import dprecall.DOAimpl.vakDAOimpl;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;
import dprecall.entitys.Vak;

import java.sql.SQLException;
import java.util.ArrayList;

public class App {
    private static studentDAOimpl studentdao = new studentDAOimpl();
    private static klasDAOimpl klasdao = new klasDAOimpl();
    private static vakDAOimpl vakdao = new vakDAOimpl();

    public static void main(String[] arg) throws SQLException {
        ArrayList<Klas> klassen;
        klassen = klasdao.findAll();

        Klas KlasV1D = klasdao.findByCode("V1D");
        KlasV1D.setMentor("Dennis Gerdings");
        klasdao.update(KlasV1D);
        System.out.println(KlasV1D);

        ArrayList<Student>studenten = studentdao.findAll();
        for (Student student: studenten) {
           student.setVakken(studentdao.vakken(student));
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
       // Klas KlasV1I = new Klas("V1I", "Meneer Janssen",2019);
      //  klasdao.save(KlasV1I);

    }

}