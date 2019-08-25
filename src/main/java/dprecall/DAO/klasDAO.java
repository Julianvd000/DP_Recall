package dprecall.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dprecall.entitys.Klas;
import dprecall.entitys.Student;


public interface klasDAO {
    public ArrayList<Klas> findAll() throws SQLException;
    public Klas findByCode(String code) throws SQLException ;
    public ArrayList<Klas> findKlassenByMentor(String mentor) throws SQLException ;
    public Klas save(Klas klas) throws SQLException;
    public Klas update(Klas klas) throws SQLException;
    public boolean delete(Klas klas);
}
