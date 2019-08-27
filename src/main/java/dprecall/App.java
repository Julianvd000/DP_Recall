package dprecall;

import dprecall.DOAimpl.klasDAOimpl;
import dprecall.DOAimpl.studentDAOimpl;
import dprecall.DOAimpl.vakDAOimpl;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;
import dprecall.entitys.Vak;

import java.sql.SQLException;

public class App {
    private static studentDAOimpl studentdao = new studentDAOimpl();
    private static klasDAOimpl klasdao = new klasDAOimpl();

    private static vakDAOimpl vakdao = new vakDAOimpl();

    public static void main(String[] arg) throws SQLException {

        Klas klas1 = new Klas("V1F", "Meneer Janssen", 2019);
        Student student1 = new Student(00001, "Julian van Dijk", null, klas1);
        Vak vak1 = new Vak("PRG", "Programmeren", 5);

        Klas klas2 = new Klas("V1G", "Wilma Petersen", 2020);
        Student student2 = new Student(00001, "maxmim hauss", null, klas2);
        Vak vak2 = new Vak("WAC", "Web Application Construction", 5);
        //Testen of save() werkt
        System.out.println("save() test:");
        System.out.println("save klas " + klasdao.save(klas1));
        System.out.println("save student " + studentdao.save(student1));
        System.out.println("save vak " + vakdao.save(vak1));

        //Testen of delete() werkt
        System.out.println("delete() test:");
        System.out.println("delete vak " + vakdao.delete(vak1));
        System.out.println("delete student " + studentdao.delete(student1));
        System.out.println("delete klas " + klasdao.delete(klas1));

        //Testen of update() werkt
        System.out.println("update() test:");
        System.out.println("update vak " + vakdao.update(vak2));
        System.out.println("update student " + studentdao.update(student2));
        System.out.println("update klas " + klasdao.update(klas2));

        //Herstelt oude waarden om later opnieuw update() te kunnen testen

    }
}