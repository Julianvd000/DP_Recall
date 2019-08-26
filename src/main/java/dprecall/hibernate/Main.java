package dprecall.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) throws SQLException, ParseException {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        //test create
        Klas klas1 = new Klas("V1A", "Meneer Janssen", 2019);
        Student student1 = new Student(00001, "Dennis de Braan", null, "V1A");
        Vak vak1 = new Vak("PRG", "Programmeren", 5);
        Volgt volgt1 = new Volgt(00001, "PRG");

        Klas klas2 = new Klas("V1B", "Wilma Petersen", 2020);
        Student student2 = new Student(00002, "Jelle de Snelle", null, "V1B");
        Vak vak2 = new Vak("WAC", "Web Application Construction", 5);
        session.save(klas1);
        session.save(student1);
        session.save(vak1);
        session.save(volgt1);
        session.save(klas2);
        session.save(student2);
        session.save(vak2);

        klas2.setStartjaar(2019);
        //test update
        session.update(klas2);
        session.update(student2);
        session.update(vak2);

        //test read
        printStudent(student1);
        Student s = session.get(Student.class, 2);
        printStudent(s);

        //test delete
        session.delete(volgt1);
        session.delete(student1);

        t.commit();
        factory.close();
        session.close();
    }

    public static void printStudent(Student s) {
        System.out.println(String.format("ID: %s, KLAS: %s NAAM: %s, GBDATUM: %s",
                s.getID(), s.getKlasCode(), s.getNaam(), s.getGBdatum()));

    }

}