package dprecall;

import dprecall.DAO.volgtDAO;
import dprecall.DOAimpl.klasDAOimpl;
import dprecall.DOAimpl.studentDAOimpl;
import dprecall.DOAimpl.volgtDAOimpl;
import dprecall.entitys.klas;
import dprecall.entitys.student;
import dprecall.entitys.vak;
import dprecall.entitys.volgt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        klasDAOimpl klasDAO = new klasDAOimpl();
        volgtDAOimpl volgtDAO = new volgtDAOimpl();
        studentDAOimpl studentDAO = new studentDAOimpl();

        //krijg alle klassen
        List<klas> klassen = klasDAO.findAll();
        for (klas klas: klassen) {
            System.out.println(klas.toString());
        }
        //krijg alle studenten uit de klas v1e
        List<student> studenten = klasDAO.findbyKlasCode("V1E");

        for (student student : studenten){
            System.out.println(student.toString());
        }
        //een leerling met all zijn vakken.
        String Naam = "Julian";
        student studentOpgehaald = studentDAO.getStudent(Naam);
        List<volgt> volgingStudent = volgtDAO.findbyStudent(studentOpgehaald);
        List<vak> vakken = new ArrayList<vak>();

        for (volgt volgt: volgingStudent) {
            vakken.add(volgt.getVak());
        }
        studentOpgehaald.setVakken(vakken);

        System.out.println(studentOpgehaald.toString());
    }
}
