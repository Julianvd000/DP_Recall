package dprecall.DAO;

import dprecall.entitys.vak;

import java.sql.SQLException;
import java.util.List;

public interface vakDAO {
    public List<vak> findAll() throws SQLException;
    public boolean delete(vak vak) throws SQLException;
    public vak update(vak vak) throws SQLException;
    public boolean save(vak vak) throws SQLException;
}
