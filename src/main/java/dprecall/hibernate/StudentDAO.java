package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    public List<Student> findAll() throws SQLException;
    public Object findByID(int id) throws SQLException;
    public Student save(Student student) throws SQLException;
    public Student update(Student student) throws SQLException;
    public boolean delete(Student student) throws SQLException;
}
