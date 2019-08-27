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

        List<Klas> klassen =  klasdao.findAll();
        for (Klas klas : klassen){
            System.out.println(klas.toString());
        }
    }
}