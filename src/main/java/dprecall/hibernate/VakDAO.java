package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;

public interface VakDAO {
    public List<Vak> findAll() throws SQLException ;
    public Object findByVakCode(String code) throws SQLException;
    public Vak save(Vak vak) throws SQLException;
    public Vak update(Vak vak) throws SQLException ;
    public boolean delete(Vak vak) throws SQLException;
}
