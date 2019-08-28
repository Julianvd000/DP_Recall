package dprecall.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;


public class JPAApp extends HibernateBaseDao {
    private static Session session;

    public static void main (String[] args) throws SQLException, ParseException {
        session = getSession();
        KlasHibernateDaoImpl klasdao = new KlasHibernateDaoImpl();
        VakHibernateDaoImpl vakdao = new VakHibernateDaoImpl();
        StudentHibernateDaoImpl studentdao = new StudentHibernateDaoImpl();

        Vak vak1 = new Vak("RAD", "Rapid Application Development", 5);
        Klas klas1 = new Klas("V2A", "James", 2019);
        Student student1 = new Student(3,"Rick", null , klas1);

        klasdao.save(klas1);
        vakdao.save(vak1);
        student1.voegVakToe(vak1);
        studentdao.save(student1);

        for (Klas klas : klasdao.findAll()){
            System.out.println(klas.toString());
        }

        System.out.println("update sommige objecten \n");
        vak1.setNaam("Rapid Applications DevelopmentScience");
        vakdao.update(vak1);
        klas1.setStartjaar(2018);
        klasdao.update(klas1);
        student1.setNaam("James Maxim");
        studentdao.update(student1);

        for (Klas klas : klasdao.findAll()){
            System.out.println(klas.toString());
        }

        System.out.println("delete sommige objecten \n");
        studentdao.delete(student1);
        vakdao.delete(vak1);
        klasdao.delete(klas1);

        for (Klas klas : klasdao.findAll()){
            System.out.println(klas.toString());
        }
    }
}