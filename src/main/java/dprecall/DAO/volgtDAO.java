package dprecall.DAO;

import dprecall.entitys.student;
import dprecall.entitys.vak;
import dprecall.entitys.volgt;

import java.sql.SQLException;
import java.util.List;

public interface volgtDAO {
    public List<volgt> findAll() throws SQLException;
    public List<volgt> findbyStudent(student studentin) throws SQLException;
    public boolean save(vak vak, student student) throws SQLException;
}
