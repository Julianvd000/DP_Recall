package dprecall.DAO;

import java.sql.SQLException;
import java.util.List;
import dprecall.entitys.Student;

public interface studentDAO {
    public List<Student> findAll() throws SQLException;
    public Object findByID(int id) throws SQLException;
    public Student save(Student student) throws SQLException;
    public Student update(Student student) throws SQLException;
    public boolean delete(Student student) throws SQLException;
}
