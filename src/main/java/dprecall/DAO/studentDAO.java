package dprecall.DAO;

import dprecall.entitys.student;

import java.sql.SQLException;
import java.util.List;

public interface studentDAO {
    public List<student> findAll() throws SQLException;
    public student getStudent(String naam)throws SQLException;
    public boolean save(student student) throws SQLException;
    public student update(student student) throws SQLException;
    public boolean delete(student student) throws SQLException;
}
