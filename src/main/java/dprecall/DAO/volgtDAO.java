package dprecall.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;
import dprecall.entitys.Vak;
import dprecall.entitys.Volgt;

public interface volgtDAO {
    public ArrayList<Volgt> findAll() throws SQLException ;
    public ArrayList<Volgt> findVakkenByStudent(Student student) throws SQLException;
    public Volgt save(Volgt volgt) throws SQLException ;
    public boolean delete(Volgt volgt) ;
}
