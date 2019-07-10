package dprecall.DOAimpl;

import dprecall.DAO.klasDAO;
import dprecall.OracleBaseDao;
import dprecall.entitys.klas;
import dprecall.entitys.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class klasDAOimpl  extends OracleBaseDao implements klasDAO {
    private static Connection conn;

    public List<student> findbyKlasCode(String klascode) throws SQLException {
        List<student> studenten = new ArrayList<student>();
        conn = this.getConnection();

        String sql = "SELECT * FROM STUDENT JOIN KLAS ON KLAS.CODE = STUDENT.KLAS_CODE WHERE STUDENT.KLAS_CODE = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, klascode);
        ResultSet result = statement.executeQuery();

        while (result.next()){
            klas klas = new klas();
            student student = new student();

            student.setId(result.getInt("ID"));
            student.setNaam(result.getString("NAAM"));
            if (result.getDate("GBDATUM") != null){
                student.setGbdatum(result.getDate("GBDATUM"));
            }
            if (result.getString("KLAS_CODE") != null){
                klas.setCode(result.getString("CODE"));
                klas.setMentor(result.getString("MENTOR"));
                klas.setStartjaar(result.getInt("STARTJAAR"));
                student.setKlas_code(klas);
            }
            studenten.add(student);
        }
        return studenten;
    }

    public List<klas> findAll() throws SQLException {
        List<klas> klassen = new ArrayList<klas>();
        conn = this.getConnection();

        String sql = "SELECT * FROM KLAS";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()){
            klas klas = new klas();
            klas.setCode(result.getString("CODE"));
            klas.setMentor(result.getString("MENTOR"));
            klas.setStartjaar(result.getInt("STARTJAAR"));
            klassen.add(klas);
        }
        return klassen;
    }
}
