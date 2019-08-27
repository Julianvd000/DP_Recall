package dprecall.hibernate;

import java.sql.SQLException;
import java.util.List;

public interface KlasDAO {
    public List<Klas> findAll() throws SQLException;
    public Object findByKlasCode(String code) throws SQLException;
    public Klas save(Klas klas) throws SQLException;
    public Klas update(Klas klas) throws SQLException ;
    public boolean delete(Klas klas) throws SQLException ;
}
