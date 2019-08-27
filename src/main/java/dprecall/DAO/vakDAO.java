package dprecall.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import dprecall.entitys.Vak;

public interface vakDAO {
    public ArrayList<Vak> findAll() throws SQLException ;
    public Vak findByCode(String code) throws SQLException ;
    public Vak save(Vak vak) throws SQLException ;
    public Vak update(Vak vak) throws SQLException ;
    public boolean delete(Vak vak) ;
}
