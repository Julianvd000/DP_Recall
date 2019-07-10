package dprecall.DAO;

import dprecall.entitys.klas;
import dprecall.entitys.student;

import java.sql.SQLException;
import java.util.List;

public interface klasDAO {
    public List<student> findbyKlasCode(String klascode)throws SQLException;
    public List<klas> findAll() throws SQLException;
    public boolean delete(klas klas) throws SQLException;
}
