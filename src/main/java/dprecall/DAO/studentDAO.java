package dprecall.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import dprecall.entitys.Klas;
import dprecall.entitys.Student;

public interface studentDAO {
    public ArrayList<Student> findAll() throws SQLException ;

    public Student findByID(int id) throws SQLException ;

    public ArrayList<Student> findStudentenByKlas(Klas klas) throws SQLException;

    public Student save(Student student) throws SQLException;

    public Student update(Student student) throws SQLException ;

    public boolean delete(Student student);
}
